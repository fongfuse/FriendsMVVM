package com.fongfuse.friendsapp.presentation.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open class BaseFragment<DB : ViewDataBinding>(
    @LayoutRes layout: Int
) : Fragment(layout) {

    protected lateinit var binding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.also {
            binding = DataBindingUtil.bind(it)!!
            binding.lifecycleOwner = viewLifecycleOwner
            binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT in 21..29) {
            requireActivity().window.apply {
                statusBarColor = Color.TRANSPARENT
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                decorView.systemUiVisibility =
                    SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            requireActivity().window.apply {
                statusBarColor = Color.TRANSPARENT
                // Making status bar overlaps with the activity
                WindowCompat.setDecorFitsSystemWindows(this, false)
            }

        }
    }
}
