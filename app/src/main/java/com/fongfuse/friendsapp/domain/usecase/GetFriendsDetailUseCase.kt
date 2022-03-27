package com.fongfuse.friendsapp.domain.usecase

import com.fongfuse.friendsapp.data.Status
import com.fongfuse.friendsapp.domain.model.Friends
import kotlinx.coroutines.flow.Flow

interface GetFriendsDetailUseCase {
    fun execute(apiKey: String): Flow<Status<Friends>>
}