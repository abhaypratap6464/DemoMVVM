package com.android.example.demoMvvM.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IssueDataItem(
    var id: String?,
    var title: String?,
    var description: String?,
    var userName: String?,
    var updatedAt: String?,
    var avatarUrl: String?,
    var commentNo:Int?
) : Parcelable