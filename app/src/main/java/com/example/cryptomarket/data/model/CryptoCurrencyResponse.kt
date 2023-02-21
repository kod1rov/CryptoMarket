package com.example.cryptomarket.data.model

import com.google.gson.annotations.SerializedName

data class CryptoCurrencyResponse(
    @SerializedName("data"      ) var data      : ArrayList<Data> = arrayListOf(),
    @SerializedName("timestamp" ) var timestamp : String?            = null
)

data class Data (
    @SerializedName("id"                ) var id                : String? = null,
    @SerializedName("rank"              ) var rank              : String? = null,
    @SerializedName("symbol"            ) var symbol            : String? = null,
    @SerializedName("name"              ) var name              : String? = null,
    @SerializedName("supply"            ) var supply            : String? = null,
    @SerializedName("maxSupply"         ) var maxSupply         : String? = null,
    @SerializedName("marketCapUsd"      ) var marketCapUsd      : String? = null,
    @SerializedName("volumeUsd24Hr"     ) var volumeUsd24Hr     : String? = null,
    @SerializedName("priceUsd"          ) var priceUsd          : String? = null,
    @SerializedName("changePercent24Hr" ) var changePercent24Hr : Double? = null,
    @SerializedName("vwap24Hr"          ) var vwap24Hr          : String? = null,
    @SerializedName("explorer"          ) var explorer          : String? = null
)

