package com.example.cryptomarket.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    val newsID: Int,
    val newsPicture: Int,
    val newsTitle: String,
    val newsDescription: CharSequence
) : Parcelable
