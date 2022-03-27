package com.fongfuse.friendsapp.di

import com.fongfuse.friendsapp.domain.usecase.GetCastsUseCase
import com.fongfuse.friendsapp.domain.usecase.GetFriendsDetailUseCase
import com.fongfuse.friendsapp.domain.usecase.impl.GetCastsUseCaseImpl
import com.fongfuse.friendsapp.domain.usecase.impl.GetFriendsDetailUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetFriendsDetailImpl(getFriendsDetailUseCaseImpl: GetFriendsDetailUseCaseImpl)
    : GetFriendsDetailUseCase {
        return getFriendsDetailUseCaseImpl
    }

    @Singleton
    @Provides
    fun provideGetCastsImpl(getCastsUseCaseImpl: GetCastsUseCaseImpl)
            : GetCastsUseCase {
        return getCastsUseCaseImpl
    }
}