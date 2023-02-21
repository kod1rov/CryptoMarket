package com.example.cryptomarket.data.remote.impl

import com.devcraft.currencyassistant.data.remote.network.NetworkResult
import com.example.cryptomarket.data.model.CryptoCurrencyResponse
import com.example.cryptomarket.data.remote.service.CryptoCurrencyService
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoCurrencyRepoImpl @Inject constructor(
    private val client: HttpClient
) : CryptoCurrencyService {

    override suspend fun getCryptoData(): NetworkResult<CryptoCurrencyResponse> = try {
        val result = client.get<CryptoCurrencyResponse> {
            url("https://api.coincap.io/v2/assets")
        }
        NetworkResult.Success(result)
    } catch (ex: Exception) {
        NetworkResult.ApiError(ex.localizedMessage ?: "")
    }
}