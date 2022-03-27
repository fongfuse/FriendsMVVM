package com.fongfuse.friendsapp.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T, VH : RecyclerView.ViewHolder>(
    diffUtil: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(diffUtil) {

    protected fun <DB : ViewDataBinding> getViewBinding(
        parent: ViewGroup,
        @LayoutRes layout: Int
    ): DB {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), layout, parent, false
        )
    }
}