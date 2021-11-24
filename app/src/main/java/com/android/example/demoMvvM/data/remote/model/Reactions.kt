package com.android.example.demoMvvM.data.remote.model

import com.squareup.moshi.Json


data class Reactions(

   @Json(name = "url") var url: String?,
   @Json(name = "total_count") var totalCount: Int?,
   @Json(name = "+1") var plusOne: Int?,
   @Json(name = "-1") var minusOne: Int?,
   @Json(name = "laugh") var laugh: Int?,
   @Json(name = "hooray") var hooray: Int?,
   @Json(name = "confused") var confused: Int?,
   @Json(name = "heart") var heart: Int?,
   @Json(name = "rocket") var rocket: Int?,
   @Json(name = "eyes") var eyes: Int?,

   )