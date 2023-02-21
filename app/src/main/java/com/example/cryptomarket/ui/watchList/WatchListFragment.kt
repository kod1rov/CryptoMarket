package com.example.cryptomarket.ui.watchList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptomarket.BaseFragment
import com.example.cryptomarket.databinding.FragmentWatchListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WatchListFragment :
    BaseFragment<FragmentWatchListBinding>(FragmentWatchListBinding::inflate) {

    private val vm: WatchListViewModel by viewModels()
    private val watchListAdapter = WatchListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        vm.currencyLiveData.observe(viewLifecycleOwner) {
            watchListAdapter.submitData(it)
        }
        vm.run()
    }

    private fun initViews() {
        binding?.run {
            recyclerView.adapter = watchListAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}