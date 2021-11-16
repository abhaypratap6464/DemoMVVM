package com.android.example.demomvvm.ui.issue

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.android.example.demomvvm.core.base.BaseViewModel
import com.android.example.demomvvm.data.DemoDataSource
import kotlinx.coroutines.launch

class IssueViewModel(
    val app: Application,
    private val repository: DemoDataSource,
) : BaseViewModel(app) {

    val issuesList = repository.getIssues()

    init {
        loadIssue()
    }


    fun loadIssue() {
        showLoading.value = true
        viewModelScope.launch {
           repository.refreshIssue()
            showLoading.value = false
        }
    }
}