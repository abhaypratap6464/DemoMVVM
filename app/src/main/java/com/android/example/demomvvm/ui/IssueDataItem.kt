package com.android.example.demomvvm.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IssueDataItem(
    var id: Int?,
    var title: String?,
    var description: String?,
    var userName: String?,
    var updatedAt: String?,
    var avatarUrl: String?,
    var commentNo:Int?
) : Parcelable