package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.data.database.CoinInfoDbModel
import com.example.cryptoapp.data.network.model.CoinInfoDto
import com.example.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.example.cryptoapp.data.network.model.CoinNamesListDto
import com.example.cryptoapp.domain.CoinInfo
import com.google.gson.Gson

class CoinMapper {
    fun mapDtoToDbModel(dto: CoinInfoDto): CoinInfoDbModel =
        with(dto) {
            return CoinInfoDbModel(
                fromSymbol,
                toSymbol,
                price,
                lastUpdate,
                highDay,
                lowDay,
                lastMarket,
                imageUrl,
            )
        }

    fun mapJsonContainerToListContainerInfo(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(nameListDto: CoinNamesListDto): String {
        return nameListDto.names?.map { it.coinName?.name }?.joinToString(",") ?: ""
    }

    fun mapDbModelToEntity(dbModel: CoinInfoDbModel): CoinInfo =
        with(dbModel) {
            return CoinInfo(
                fromSymbol,
                toSymbol,
                price,
                lastUpdate,
                highDay,
                lowDay,
                lastMarket,
                imageUrl,
            )
        }
}



