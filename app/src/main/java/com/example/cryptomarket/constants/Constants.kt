package com.example.cryptomarket.constants

import com.example.cryptomarket.R
import com.example.cryptomarket.data.model.News
import android.content.Context

class Constants(ctx: Context) {
    val news = listOf(
        News(
            newsID = 1,
            newsPicture = R.drawable.news_1,
            newsTitle = "XRP to be Used by a Payment Provider in the UAE",
            newsDescription = ctx.resources.getText(R.string.news_1)
        ),
        News(
            newsID = 2,
            newsPicture = R.drawable.news_2,
            newsTitle = "Helium Foundation Proposes March 27th as Transition Date to Solana Blockchain",
            newsDescription = ctx.resources.getText(R.string.news_2)
        ),
        News(
            newsID = 3,
            newsPicture = R.drawable.news_3,
            newsTitle = "Alchemy Pay token price spikes 67% following support for Google Pay",
            newsDescription = ctx.resources.getText(R.string.news_3)
        ),
        News(
            newsID = 4,
            newsPicture = R.drawable.news_4,
            newsTitle = "TechOps Core Unit takes over management of MakerDAO Github",
            newsDescription = ctx.resources.getText(R.string.news_4)
        ),
        News(
            newsID = 5,
            newsPicture = R.drawable.news_5,
            newsTitle = "FTX Japan Customers Can Begin Withdrawing Fiat, Crypto on Feb. 21",
            newsDescription = ctx.resources.getText(R.string.news_5)
        ),
        News(
            newsID = 6,
            newsPicture = R.drawable.news_6,
            newsTitle = "Animoca Brands invests in EthSign to back its new product TokenTable",
            newsDescription = ctx.resources.getText(R.string.news_6)
        ),
        News(
            newsID = 7,
            newsPicture = R.drawable.news_7,
            newsTitle = "Klaytn Foundation Introduces Key Changes in Governance and Tokenomics",
            newsDescription = ctx.resources.getText(R.string.news_7)
        )
    )
}