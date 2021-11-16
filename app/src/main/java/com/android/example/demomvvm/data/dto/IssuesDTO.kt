package com.android.example.demomvvm.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.example.demomvvm.ui.IssueDataItem
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IssueDTOContainer(val issues: List<IssuesDTO>)

/**
 * Immutable model class for a Issue. In order to compile with Room
 *
 * @param title         title of the issue
 * @param description   description of the issue
 * @param userName       name of the user who has raised the issue
 * @param updatedAt      time at which issue is updated
 * @param avatarUrl     image of the user
 * @param id          id of the issue
 * @param commentNo   number of comments to the user issue
 */

@Entity(tableName = "issues")
data class IssuesDTO(
    @PrimaryKey @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "userName") var userName: String?,
    @ColumnInfo(name = "updatedAt") var updatedAt: String?,
    @ColumnInfo(name = "avatarUrl") var avatarUrl: String?,
    @ColumnInfo(name = "commentNo") var commentNo: Int?,
)

fun IssueDTOContainer.asDomainModel(): Array<IssueDataItem> {
    return issues.map {
        IssueDataItem(
            title = it.title,
            description = it.description,
            updatedAt = it.updatedAt,
            avatarUrl = it.avatarUrl,
            commentNo = it.commentNo,
            id = it.id,
            userName = it.userName
        )
    }.toTypedArray()
}
