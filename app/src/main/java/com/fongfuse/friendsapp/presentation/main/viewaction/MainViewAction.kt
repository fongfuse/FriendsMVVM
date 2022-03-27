package com.fongfuse.friendsapp.presentation.main.viewaction

import com.fongfuse.friendsapp.domain.model.Casts
import com.fongfuse.friendsapp.domain.model.Friends

sealed class MainViewAction {
    class GetFriendsDetailSuccess(val data: Friends): MainViewAction()
    class GetCastsSuccess(val data: Casts): MainViewAction()

    class Failed(val errorMessage: String): MainViewAction()
}