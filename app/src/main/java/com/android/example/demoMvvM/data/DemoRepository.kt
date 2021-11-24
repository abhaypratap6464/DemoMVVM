package com.android.example.demoMvvM.data


import androidx.paging.PagingSource
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.data.local.dao.DemoDao
import com.android.example.demoMvvM.data.remote.DemoApiService
import com.android.example.demoMvvM.data.remote.model.Issues
import com.android.example.demoMvvM.data.remote.model.IssuesComment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class DemoRepository(
    private val service: DemoApiService,
    private val dao: DemoDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : DemoDataSource {


    override suspend fun getIssueDetails(commentId: Int): Result<List<IssuesComment>> =
        withContext(dispatcher) {
            try {
                return@withContext Result.Success(service.getIssuesComment(comment_id = commentId.toString()))
            } catch (ex: Exception) {
                Result.Error(ex.localizedMessage)
            }
        }


    override fun getIssue(): PagingSource<Int, IssuesDTO> {
        return dao.getAllIssue()
    }

    override suspend fun getAllIssues(page: Int, limit: Int): List<Issues> {
        return service.getIssues(page, limit).await()
    }

}