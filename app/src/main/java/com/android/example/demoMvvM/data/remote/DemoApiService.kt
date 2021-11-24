package com.android.example.demoMvvM.data.remote


import com.android.example.demoMvvM.data.remote.model.Issues
import com.android.example.demoMvvM.data.remote.model.IssuesComment
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.github.com/repos/square/okhttp/"

private val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()


interface DemoApiService {
    @GET("issues")
     fun getIssues(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): Deferred<List<Issues>>

    @GET("issues/{comment_id}/comments")
    suspend fun getIssuesComment(
        @Path("comment_id") comment_id: String,
    ): List<IssuesComment>
}

object DemoApi {
    fun createRetrofitService(): DemoApiService = retrofit.create(DemoApiService::class.java)
}
