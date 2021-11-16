package com.android.example.demomvvm.data


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.example.demomvvm.data.dto.IssueDTOContainer
import com.android.example.demomvvm.data.dto.asDomainModel
import com.android.example.demomvvm.data.local.DemoDao
import com.android.example.demomvvm.data.remote.DemoApiService
import com.android.example.demomvvm.data.remote.model.IssueContainer
import com.android.example.demomvvm.data.remote.model.IssuesComment
import com.android.example.demomvvm.data.remote.model.asDatabaseModel
import com.android.example.demomvvm.ui.IssueDataItem
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

    override suspend fun refreshIssue() {
        withContext(dispatcher) {
            try {
                val issues = service.getIssues()
                dao.insertAllIssues(*IssueContainer(issues).asDatabaseModel())
            } catch (ex: Exception) {
                Result.Error(ex.localizedMessage)
            }
        }
    }

    override fun getIssues(): LiveData<List<IssueDataItem>> =
        Transformations.map(dao.getAllIssues()) {
            IssueDTOContainer(it).asDomainModel().toList()
        }

}