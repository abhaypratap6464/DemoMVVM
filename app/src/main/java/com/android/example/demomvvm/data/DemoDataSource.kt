package com.android.example.demomvvm.data

import androidx.lifecycle.LiveData
import com.android.example.demomvvm.data.remote.model.IssuesComment
import com.android.example.demomvvm.ui.IssueDataItem


interface DemoDataSource {

    suspend fun getIssueDetails(commentId: Int): Result<List<IssuesComment>>

    suspend fun refreshIssue()

     fun getIssues(): LiveData<List<IssueDataItem>>


}