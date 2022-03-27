package com.fongfuse.friendsapp.domain.usecase

import com.fongfuse.friendsapp.data.Status
import com.fongfuse.friendsapp.domain.model.Casts
import com.fongfuse.friendsapp.domain.model.Friends
import kotlinx.coroutines.flow.Flow

interface GetCastsUseCase {
    fun execute(apiKey: String): Flow<Status<Casts>>
}