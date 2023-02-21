package com.example.cryptomarket.ui.watchList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcraft.currencyassistant.data.remote.network.NetworkResult
import com.example.cryptomarket.R
import com.example.cryptomarket.data.model.CryptoCurrencyResponse
import com.example.cryptomarket.data.model.Data
import com.example.cryptomarket.data.remote.impl.CryptoCurrencyRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val cryptoService: CryptoCurrencyRepoImpl
) : ViewModel() {

    private var _currencyLiveData = MutableLiveData<List<Data>>(mutableListOf())
    var currencyLiveData: LiveData<List<Data>> = _currencyLiveData

    private val hashCrypto = hashMapOf<String, Int>().apply {
        put("BTC", R.drawable.btc)
        put("ETH", R.drawable.eth)
        put("USDT", R.drawable.usdt)
        put("BNB", R.drawable.bnb)
        put("USDC", R.drawable.usdc)
        put("XRP", R.drawable.xrp)
        put("BUSD", R.drawable.busd)
        put("ADA", R.drawable.ada)
        put("DOGE", R.drawable.doge)
        put("MATIC", R.drawable.matic)
        put("SOL", R.drawable.sol)
        put("DOT", R.drawable.dot)
        put("LUNA", R.drawable.luna)
        put("SHIB", R.drawable.shib)
        put("LTC", R.drawable.ltc)
        put("DAI", R.drawable.dai)
        put("TRX", R.drawable.trx)
        put("AVAX", R.drawable.avax)
        put("UNI", R.drawable.uni)
        put("WBTC", R.drawable.wbtc)
    }

    private val list = arrayListOf<Data>()
    private val scope = CoroutineScope(Dispatchers.IO)

    private var isRun = false
    fun run() {
        if (isRun) return
        requestData()
    }

    private fun requestData() = scope.launch {
        while (true) {
            val result = cryptoService.getCryptoData()
            checkResult(result)
            delay(5000)
        }
    }

    private suspend fun checkResult(result: NetworkResult<CryptoCurrencyResponse>) =
        withContext(Dispatchers.IO) {
            when (result) {
                is NetworkResult.ApiError -> {
                    Log.d("ERROR", result.message)
                }
                is NetworkResult.Success -> {
                    list.clear()
                    result.data.data.forEach { crypto ->
                        crypto.image = hashCrypto[crypto.symbol]
                        list.add(crypto)
                    }
                    _currencyLiveData.postValue(list)
                }
                else -> {
                    Log.d("CLEAR", "true")
                }
            }
        }
}