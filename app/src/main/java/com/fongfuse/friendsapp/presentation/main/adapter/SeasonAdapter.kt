package com.fongfuse.friendsapp.presentation.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fongfuse.friendsapp.R
import com.fongfuse.friendsapp.databinding.ItemSeasonBinding
import com.fongfuse.friendsapp.domain.model.Friends
import com.fongfuse.friendsapp.presentation.base.BaseListAdapter

class SeasonAdapter : BaseListAdapter<Friends.Season, SeasonAdapter.SeasonViewHolder>(SeasonItemDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        return  SeasonViewHolder(
            getViewBinding(parent, R.layout.item_season)
        )
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
       holder.bindTo(getItem(position))
    }

    class SeasonViewHolder(
        private val binding: ItemSeasonBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(item: Friends.Season) {
            binding.model = item
        }
    }

    class SeasonItemDiffUtils : DiffUtil.ItemCallback<Friends.Season>() {
        override fun areItemsTheSame(oldItem: Friends.Season, newItem: Friends.Season) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Friends.Season, newItem: Friends.Season) =
            oldItem == newItem

    }
}