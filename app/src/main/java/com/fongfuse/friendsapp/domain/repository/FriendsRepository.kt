package com.fongfuse.friendsapp.domain.repository

import com.fongfuse.friendsapp.data.response.CastResponse
import com.fongfuse.friendsapp.data.response.FriendsResponse

interface FriendsRepository {
    suspend fun getFriendsDetail(apiKey: String): FriendsResponse
    suspend fun getCasts(apiKey: String): CastResponse
}