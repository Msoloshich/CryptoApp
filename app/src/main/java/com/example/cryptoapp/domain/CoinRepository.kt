package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.CoinInfo

interface CoinRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    fun loadData()
}