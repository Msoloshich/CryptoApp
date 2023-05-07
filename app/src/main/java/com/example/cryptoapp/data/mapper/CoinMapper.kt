package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.BuildConfig
import com.example.cryptoapp.data.database.CoinInfoDbModel
import com.example.cryptoapp.data.network.model.CoinInfoDto
import com.example.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.example.cryptoapp.data.network.model.CoinNamesListDto
import com.example.cryptoapp.domain.CoinInfo
import com.google.gson.Gson
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class CoinMapper {

    private fun convertTimeStampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

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
                BuildConfig.IMAGE_BASE_URL + imageUrl,
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
                convertTimeStampToTime(lastUpdate),
                highDay,
                lowDay,
                lastMarket,
                imageUrl,
            )
        }
}



