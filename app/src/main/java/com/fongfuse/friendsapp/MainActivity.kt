package com.fongfuse.friendsapp

import com.fongfuse.friendsapp.databinding.ActivityMainBinding
import com.fongfuse.friendsapp.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResId() = R.layout.activity_main
}