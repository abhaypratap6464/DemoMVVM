package com.android.example.demoMvvM.ui.issueDetails.adapter

import com.android.example.demoMvvM.R
import com.android.example.demoMvvM.core.base.BaseRecyclerViewAdapter
import com.android.example.demoMvvM.ui.IssueDataItem

//Use data binding to show the reminder on the item
class IssueDetailListAdapter :
    BaseRecyclerViewAdapter<IssueDataItem>() {
    override fun getLayoutRes(viewType: Int) = R.layout.it_issue_list
}