package com.example.cryptomarket.data.remote.service

import com.devcraft.currencyassistant.data.remote.network.NetworkResult
import com.example.cryptomarket.data.model.CryptoCurrencyResponse
import kotlinx.coroutines.flow.Flow

interface CryptoCurrencyService {

    suspend fun getCryptoData() : NetworkResult<CryptoCurrencyResponse>
}