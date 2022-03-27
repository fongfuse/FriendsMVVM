package com.fongfuse.friendsapp.data.repository

import com.fongfuse.friendsapp.data.ApiService
import com.fongfuse.friendsapp.data.response.CastResponse
import com.fongfuse.friendsapp.data.response.FriendsResponse
import com.fongfuse.friendsapp.domain.repository.FriendsRepository
import javax.inject.Inject

class FriendsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : FriendsRepository {

    override suspend fun getFriendsDetail(apiKey: String): FriendsResponse {
        return apiService.getFriendsDetail(apiKey)
    }

    override suspend fun getCasts(apiKey: String): CastResponse {
        return apiService.getCasts(apiKey)
    }
}