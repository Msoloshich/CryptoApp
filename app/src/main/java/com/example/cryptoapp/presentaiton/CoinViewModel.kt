package com.example.cryptoapp.presentaiton

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.*
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)


    val coinInfoList = getCoinInfoListUseCase()

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)


}