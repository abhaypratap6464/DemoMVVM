package com.android.example.demomvvm.ui.issue.adapter

import com.android.example.demomvvm.R
import com.android.example.demomvvm.core.base.BaseRecyclerViewAdapter
import com.android.example.demomvvm.ui.IssueDataItem


//Use data binding to show the reminder on the item
class IssueListAdapter(callBack: (selectedIssue: IssueDataItem) -> Unit) :
    BaseRecyclerViewAdapter<IssueDataItem>(callBack) {
    override fun getLayoutRes(viewType: Int) = R.layout.it_issue_list
}