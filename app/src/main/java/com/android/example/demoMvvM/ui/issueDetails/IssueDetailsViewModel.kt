package com.android.example.demoMvvM.ui.issueDetails

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.example.demoMvvM.R
import com.android.example.demoMvvM.core.base.BaseViewModel
import com.android.example.demoMvvM.data.DemoDataSource
import com.android.example.demoMvvM.data.Result
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.data.remote.model.IssuesComment
import com.udacity.project4.core.base.NavigationCommand
import kotlinx.coroutines.launch

class IssueDetailsViewModel(
    val app: Application,
    private val repository: DemoDataSource,
) :
    BaseViewModel(app) {

    val issuesDetailsList = MutableLiveData<List<IssuesDTO>>()

    fun loadIssueDetails(commentId: Int, commentNo: Int) {
        if (commentNo == 0) {
            showSnackBar.value = app.getString(R.string.no_comment_available)
            navigationCommand.value = NavigationCommand.Back
        } else
            showLoading.value = true
        viewModelScope.launch {
            val result = repository.getIssueDetails(commentId)
            showLoading.value = false
            when (result) {
                is Result.Success<*> -> {
                    val dataList = ArrayList<IssuesDTO>()
                    dataList.addAll((result.data as List<IssuesComment>).map { issues ->
                        //map the reminder data from the DB to the be ready to be displayed on the UI
                        IssuesDTO(
                            issues.nodeId!!,
                            issues.id,
                            issues.nodeId,
                            issues.body,
                            issues.user.login,
                            issues.updatedAt,
                            issues.user.avatarUrl,
                            0
                        )
                    })
                    issuesDetailsList.value = dataList
                }
                is Result.Error ->
                    showSnackBar.value = result.message
            }
        }
    }

}