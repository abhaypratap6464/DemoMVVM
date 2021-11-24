package com.android.example.demoMvvM.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.data.local.DemoDatabase
import com.android.example.demoMvvM.data.local.RemoteKeys
import com.android.example.demoMvvM.data.remote.model.IssueContainer
import com.android.example.demoMvvM.data.remote.model.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

@ExperimentalPagingApi
class IssueRemoteMediator(private val repository: DemoDataSource, private val db: DemoDatabase) :
    RemoteMediator<Int, IssuesDTO>() {
    private val STARTING_PAGE_INDEX = 1

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, IssuesDTO>,
    ): MediatorResult {
        val pageKeyData = getKeyPageData(loadType, state)
        val page = when (pageKeyData) {
            is MediatorResult.Success -> {
                return pageKeyData
            }
            else -> {
                pageKeyData as Int
            }
        }

        try {
            val response = repository.getAllIssues(page, state.config.pageSize)
            val endOfList = response.isEmpty()
            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.remoteKeyDao.clearAll()
                    db.demoDao.clearAll()
                }
                val prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1
                val nextKey = if (endOfList) null else page + 1
                Timber.i("nextKey$nextKey")
                val keys = response.map {
                    RemoteKeys(it.nodeId!!, prevKey, nextKey)
                }
                db.remoteKeyDao.insertRemote(keys)
                db.demoDao.insertAllIssues(IssueContainer(response).asDatabaseModel().toList())
            }
            return MediatorResult.Success(endOfPaginationReached = endOfList)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }


    private suspend fun getKeyPageData(
        loadType: LoadType,
        state: PagingState<Int, IssuesDTO>,
    ): Any {
        return when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRefreshRemoteKey(state)
                remoteKeys?.nextKey?.minus(1) ?: STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getFirstRemoteKey(state)
                val prevKey = remoteKeys?.prevKey ?: MediatorResult.Success(
                    endOfPaginationReached = false
                )
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getLastRemoteKey(state)
                val nextKey = remoteKeys?.nextKey ?: MediatorResult.Success(
                    endOfPaginationReached = true
                )
                nextKey
            }
        }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, IssuesDTO>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.pages
                .firstOrNull { it.data.isNotEmpty() }
                ?.data?.firstOrNull()
                ?.let { issues -> db.remoteKeyDao.getRemoteKeys(issues.id) }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, IssuesDTO>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.pages
                .lastOrNull { it.data.isNotEmpty() }
                ?.data?.lastOrNull()
                ?.let { issues -> db.remoteKeyDao.getRemoteKeys(issues.id) }
        }
    }

    private suspend fun getRefreshRemoteKey(state: PagingState<Int, IssuesDTO>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.anchorPosition?.let { position ->
                state.closestItemToPosition(position)?.id?.let { repId ->
                    db.remoteKeyDao.getRemoteKeys(repId)
                }
            }
        }
    }

}
