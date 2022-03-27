package com.fongfuse.friendsapp.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T>: ViewModel() {
    protected val _isLoading by lazy { MutableLiveData(false) }
    val isLoading: LiveData<Boolean> = _isLoading

    protected val _viewAction by lazy { MutableLiveData<T>() }
    val viewAction: LiveData<T> = _viewAction

    protected val _isShowContent by lazy { MutableLiveData(false) }
    val isShowContent: LiveData<Boolean> = _isShowContent
}
