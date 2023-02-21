package com.example.cryptomarket.ui.news

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.cryptomarket.BaseFragment
import com.example.cryptomarket.databinding.FragmentPageBinding


class PageFragment : BaseFragment<FragmentPageBinding>(FragmentPageBinding::inflate) {

    private val args: PageFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initViews() {
        binding?.run {
            args.newsData.let {
                newsTitle.text = it?.newsTitle
                newsPicture.setBackgroundResource(it?.newsPicture!!)
                newsDescription.text = it.newsDescription
            }
        }
    }

    private fun initListeners() {
        binding?.run {
            btnBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}