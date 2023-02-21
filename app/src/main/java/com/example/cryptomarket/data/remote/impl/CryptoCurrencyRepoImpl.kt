package com.example.cryptomarket.data.remote.impl

import com.devcraft.currencyassistant.data.remote.network.NetworkResult
import com.example.cryptomarket.data.model.CryptoCurrencyResponse
import com.example.cryptomarket.data.remote.service.CryptoCurrencyService
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoCurrencyRepoImpl  @Inject constructor(
    private val client: HttpClient
) : CryptoCurrencyService {

    override suspend fun getCryptoData(): Flow<NetworkResult<CryptoCurrencyResponse>> = flow<NetworkResult<CryptoCurrencyResponse>>{
        val query = client.get<CryptoCurrencyResponse> {
            url("https://api.coincap.io/v2/assets")
        }
        emit(NetworkResult.Success(query))
    }.catch{
        emit(NetworkResult.ApiError(it.localizedMessage.toString()))
    }.flowOn(Dispatchers.IO)
}