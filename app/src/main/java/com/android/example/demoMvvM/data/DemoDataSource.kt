package com.android.example.demoMvvM.data

import androidx.paging.PagingSource
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.data.remote.model.Issues
import com.android.example.demoMvvM.data.remote.model.IssuesComment


interface DemoDataSource {

    suspend fun getIssueDetails(commentId: Int): Result<List<IssuesComment>>

    fun getIssue(): PagingSource<Int, IssuesDTO>

    suspend fun getAllIssues(page: Int, limit: Int): List<Issues>

}