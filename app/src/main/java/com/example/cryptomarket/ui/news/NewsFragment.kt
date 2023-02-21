package com.example.cryptomarket.ui.news

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptomarket.BaseFragment
import com.example.cryptomarket.MainActivity
import com.example.cryptomarket.constants.Constants
import com.example.cryptomarket.databinding.FragmentNewsBinding

class NewsFragment : BaseFragment<FragmentNewsBinding>(FragmentNewsBinding::inflate) {

    private lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsAdapter = NewsAdapter(Constants(requireContext()).news){
            navController.navigate(NewsFragmentDirections.actionNewsFragmentToPageFragment(it))
            (activity as MainActivity).hideBnv()
        }

        initViews()
        initListeners()
    }

    private fun initViews() {
        (activity as MainActivity).showBnv()
        binding?.run {
            recyclerView.adapter = newsAdapter
            recyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initListeners() {
        binding?.run {

        }
    }
}