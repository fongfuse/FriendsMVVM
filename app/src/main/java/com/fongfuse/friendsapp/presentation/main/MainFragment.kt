package com.fongfuse.friendsapp.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.fongfuse.friendsapp.R
import com.fongfuse.friendsapp.databinding.FragmentMainBinding
import com.fongfuse.friendsapp.domain.model.Casts
import com.fongfuse.friendsapp.domain.model.Friends
import com.fongfuse.friendsapp.presentation.base.BaseFragment
import com.fongfuse.friendsapp.presentation.main.adapter.CastAdapter
import com.fongfuse.friendsapp.presentation.main.adapter.SeasonAdapter
import com.fongfuse.friendsapp.presentation.main.viewaction.MainViewAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()
    private val seasonAdapter by lazy { SeasonAdapter() }
    private val castAdapter by lazy { CastAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStatusBarTransparent()
        initView()
        initRecyclerView()
        initObservers()
        fetchFriendsDetail()
    }

    private fun initView() {
        binding.viewModel = viewModel
    }

    private fun initRecyclerView() {
        binding.layoutSeason.rvSeasons.apply {
            adapter = seasonAdapter
        }
        binding.layoutCast.rvCast.apply {
            adapter = castAdapter
        }
    }

    private fun fetchFriendsDetail() {
        viewModel.getFriendsDetail()
    }

    private fun initObservers() {
        viewModel.viewAction.observe(viewLifecycleOwner) {
            when (it) {
                is MainViewAction.GetFriendsDetailSuccess -> {
                    handleGetFriendsDetailSuccess(it.data)
                }
                is MainViewAction.GetCastsSuccess -> {
                    handleGetCastsSuccess(it.data)
                }
                is MainViewAction.Failed -> {
                    handleFailed(it.errorMessage)
                }
            }
        }
    }

    private fun handleGetCastsSuccess(data: Casts) {
        binding.castModel = data
        castAdapter.submitList(data.cast)
    }

    private fun handleGetFriendsDetailSuccess(data: Friends) {
        binding.model = data
        seasonAdapter.submitList(data.seasons)
    }

    private fun handleFailed(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}