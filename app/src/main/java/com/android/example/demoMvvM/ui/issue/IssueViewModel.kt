package com.android.example.demoMvvM.ui.issue

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.android.example.demoMvvM.core.base.BaseViewModel
import com.android.example.demoMvvM.data.DemoDataSource
import com.android.example.demoMvvM.data.IssueRemoteMediator
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.data.local.DemoDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class IssueViewModel(
    val app: Application,
    private val repository: DemoDataSource,
    private val database: DemoDatabase,
) : BaseViewModel(app) {
    @ExperimentalPagingApi
    fun getAllDogs(): Flow<PagingData<IssuesDTO>> = Pager(
        config = PagingConfig(100, enablePlaceholders = true),
        pagingSourceFactory = { repository.getIssue() },
        remoteMediator = IssueRemoteMediator(repository,database)
    ).flow.cachedIn(viewModelScope)
}