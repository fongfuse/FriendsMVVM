package com.fongfuse.friendsapp.presentation.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fongfuse.friendsapp.R
import com.fongfuse.friendsapp.databinding.ItemCastBinding
import com.fongfuse.friendsapp.domain.model.Casts
import com.fongfuse.friendsapp.presentation.base.BaseListAdapter

class CastAdapter : BaseListAdapter<Casts.Cast, CastAdapter.CastViewHolder>(CastItemDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        return  CastViewHolder(
            getViewBinding(parent, R.layout.item_cast)
        )
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
       holder.bindTo(getItem(position))
    }

    class CastViewHolder(
        private val binding: ItemCastBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(item: Casts.Cast) {
            binding.model = item
        }
    }

    class CastItemDiffUtils : DiffUtil.ItemCallback<Casts.Cast>() {
        override fun areItemsTheSame(oldItem: Casts.Cast, newItem: Casts.Cast) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Casts.Cast, newItem: Casts.Cast) =
            oldItem == newItem

    }
}