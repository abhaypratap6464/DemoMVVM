package com.android.example.demomvvm.data.remote.model

import com.squareup.moshi.Json

data class IssuesComment(
    @Json(name = "url") var url: String?,
    @Json(name = "html_url") var htmlUrl: String?,
    @Json(name = "issue_url") var issueUrl: String?,
    @Json(name = "id") var id: Int?,
    @Json(name = "node_id") var nodeId: String?,
    @Json(name = "user") var user: User,
    @Json(name = "created_at") var createdAt: String?,
    @Json(name = "updated_at") var updatedAt: String?,
    @Json(name = "author_association") var authorAssociation: String?,
    @Json(name = "body") var body: String?,
    @Json(name = "reactions") var reactions: Reactions?,
    @Json(name = "performed_via_github_app") var performedViaGithubApp: String?,
)