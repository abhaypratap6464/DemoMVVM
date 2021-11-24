package com.android.example.demoMvvM.data.remote.model

import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Issues(
    @Json(name = "url") var url: String?,
    @Json(name = "repository_url") var repositoryUrl: String?,
    @Json(name = "labels_url") var labelsUrl: String?,
    @Json(name = "comments_url") var commentsUrl: String?,
    @Json(name = "events_url") var eventsUrl: String?,
    @Json(name = "html_url") var htmlUrl: String?,
    @Json(name = "id") var id: Int?,
    @Json(name = "node_id") var nodeId: String?,
    @Json(name = "number") var number: Int?,
    @Json(name = "title") var title: String?,
    @Json(name = "user") var user: User,
    @Json(name = "state") var state: String?,
    @Json(name = "locked") val locked: Boolean,
    @Json(name = "assignee") var assignee: String?,
    @Json(name = "comments") var comments: Int?,
    @Json(name = "created_at") var createdAt: String?,
    @Json(name = "updated_at") var updatedAt: String?,
    @Json(name = "closed_at") var closedAt: String?,
    @Json(name = "author_association") var authoroawAssociation: String?,
    @Json(name = "active_lock_reason") var activeLockReason: String?,
    @Json(name = "body") var body: String?,
    @Json(name = "timeline_url") var timelineUrl: String?,
    @Json(name = "performed_via_github_app") var performedViaGithubApp: String?,

    )

@JsonClass(generateAdapter = true)
data class IssueContainer(val issues: List<Issues>)

/**
 * Convert Issues results to database objects
 */
fun IssueContainer.asDatabaseModel(): Array<IssuesDTO> {
    return issues.map {
        IssuesDTO(
            title = it.title,
            description = it.body,
            updatedAt = it.updatedAt,
            avatarUrl = it.user.avatarUrl,
            commentNo = it.comments,
            id = it.nodeId!!,
            userName = it.user.login,
            comment_id = it.number
        )
    }.toTypedArray()
}