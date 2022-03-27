package com.fongfuse.friendsapp.di

import com.fongfuse.friendsapp.data.repository.FriendsRepositoryImpl
import com.fongfuse.friendsapp.domain.repository.FriendsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFriendsRepositoryImpl(friendsRepositoryImpl: FriendsRepositoryImpl)
    : FriendsRepository {
        return friendsRepositoryImpl
    }
}