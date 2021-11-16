package com.android.example.demomvvm.ui.issueDetails.adapter

import com.android.example.demomvvm.R
import com.android.example.demomvvm.core.base.BaseRecyclerViewAdapter
import com.android.example.demomvvm.ui.IssueDataItem

//Use data binding to show the reminder on the item
class IssueDetailListAdapter :
    BaseRecyclerViewAdapter<IssueDataItem>() {
    override fun getLayoutRes(viewType: Int) = R.layout.it_issue_list
}