package com.fongfuse.friendsapp.data

import com.fongfuse.friendsapp.data.response.CastResponse
import com.fongfuse.friendsapp.data.response.FriendsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("tv/1668")
    suspend fun getFriendsDetail(@Query("api_key") apiKey: String): FriendsResponse

    @GET("tv/1668/aggregate_credits")
    suspend fun getCasts(@Query("api_key") apiKey: String): CastResponse
}