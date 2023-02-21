package com.example.cryptomarket.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideKtorHttpClient(): HttpClient {
        return HttpClient(OkHttp) {
            expectSuccess = true
            install(JsonFeature) {
                serializer
            }
//            install(Logging) {
//                logger = Logger.DEFAULT
//                level = LogLevel.ALL
//            }
        }
    }
}

