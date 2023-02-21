package com.example.cryptomarket.ui.watchList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcraft.currencyassistant.data.remote.network.NetworkResult
import com.example.cryptomarket.data.model.CryptoCurrencyResponse
import com.example.cryptomarket.data.model.Data
import com.example.cryptomarket.data.remote.impl.CryptoCurrencyRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val cryptoService: CryptoCurrencyRepoImpl
) : ViewModel() {

    private var _currencyLiveData = MutableLiveData<MutableList<Data>>(mutableListOf())
    var currencyLiveData: LiveData<MutableList<Data>> = _currencyLiveData

    private val cryptoList = listOf(
        "BTC",
        "ETH",
        "USDT",
        "BNB",
        "USDC",
        "XRP",
        "BUSD",
        "ADA",
        "DOGE",
        "MATIC",
        "SOL",
        "DOT",
        "LUNA",
        "SHIB",
        "LTC",
        "DAI",
        "TRX",
        "AVAX",
        "UNI",
        "WBTC"
    )
    private val list = mutableListOf<Data>()

    fun repeatGetData() {
        val timer = Timer()
        timer.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    getCryptoData()
                }
            },
            0, 1000
        )
    }

    private fun getCryptoData() {
        viewModelScope.launch {
            cryptoService.getCryptoData().collect {
                checkResult(it)
            }
        }
    }

    private fun checkResult(result: NetworkResult<CryptoCurrencyResponse>) {
        when (result) {
            is NetworkResult.ApiError -> {
                Log.d("ERROR", result.message)
            }
            is NetworkResult.Success -> {
                result.data.data.forEach { crypto ->
                    cryptoList.forEach { symbol ->
                        if (crypto.symbol == symbol) {
                            list.add(crypto)
                        }
                    }
                }
                _currencyLiveData.postValue(list)
            }
            else -> {
                Log.d("CLEAR", "true")
            }
        }
    }
}