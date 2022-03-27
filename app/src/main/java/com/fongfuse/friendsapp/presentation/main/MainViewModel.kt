package com.fongfuse.friendsapp.presentation.main

import androidx.lifecycle.viewModelScope
import com.fongfuse.friendsapp.BuildConfig
import com.fongfuse.friendsapp.data.Status
import com.fongfuse.friendsapp.domain.usecase.GetCastsUseCase
import com.fongfuse.friendsapp.domain.usecase.GetFriendsDetailUseCase
import com.fongfuse.friendsapp.presentation.base.BaseViewModel
import com.fongfuse.friendsapp.presentation.main.viewaction.MainViewAction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getFriendsDetailUseCase: GetFriendsDetailUseCase,
    private val getCastsUseCase: GetCastsUseCase
) : BaseViewModel<MainViewAction>() {

    fun getFriendsDetail() {
        viewModelScope.launch {
            _isShowContent.postValue(false)
            getFriendsDetailUseCase.execute(BuildConfig.API_KEY).collect {
                when (it) {
                    is Status.Loading -> _isLoading.postValue(true)
                    is Status.Success -> {
                        getCasts()
                        _viewAction.postValue(
                            MainViewAction.GetFriendsDetailSuccess(
                                it.data!!
                            )
                        )
                    }
                    is Status.Error -> {
                        _isLoading.postValue(false)
                        _viewAction.postValue(
                            MainViewAction.Failed(
                                errorMessage = it.errorMessage.orEmpty()
                            )
                        )
                    }
                }
            }
        }
    }

    fun getCasts() {
        viewModelScope.launch {
            getCastsUseCase.execute(BuildConfig.API_KEY).collect {
                when (it) {
                    is Status.Loading -> _isLoading.postValue(true)
                    is Status.Success -> {
                        _isLoading.postValue(false)
                        _viewAction.postValue(
                            MainViewAction.GetCastsSuccess(
                                it.data!!
                            )
                        )
                        _isShowContent.postValue(true)
                    }
                    is Status.Error -> {
                        _isLoading.postValue(false)
                        _viewAction.postValue(
                            MainViewAction.Failed(
                                errorMessage = it.errorMessage.orEmpty()
                            )
                        )
                    }
                }
            }
        }
    }
}