package com.example.cryptoapp.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class CoinPriceInfo (
    @SerializedName("TYPE")
    @Expose
    private val type: String? = null,

    @SerializedName("MARKET")
    @Expose
    private val market: String? = null,

    @SerializedName("FROMSYMBOL")
    @Expose
    private val fromSymbol: String? = null,

    @SerializedName("TOSYMBOL")
    @Expose
    private val toSymbol: String? = null,

    @SerializedName("FLAGS")
    @Expose
    private val flags: String? = null,

    @SerializedName("PRICE")
    @Expose
    private val price: Double? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    private val lastUpdate: Int? = null,

    @SerializedName("MEDIAN")
    @Expose
    private val median: Double? = null,

    @SerializedName("LASTVOLUME")
    @Expose
    private val lastVolume: Double? = null,

    @SerializedName("LASTVOLUMETO")
    @Expose
    private val lastVolumeTo: Double? = null,

    @SerializedName("LASTTRADEID")
    @Expose
    private val lastTradeId: String? = null,

    @SerializedName("VOLUMEDAY")
    @Expose
    private val volumeDay: Double? = null,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    private val volumeDayTo: Double? = null,

    @SerializedName("VOLUME24HOUR")
    @Expose
    private val volume24hour: Double? = null,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    private val volume24HourTo: Double? = null,

    @SerializedName("OPENDAY")
    @Expose
    private val openDay: Double? = null,

    @SerializedName("HIGHDAY")
    @Expose
    private val highDay: Double? = null,

    @SerializedName("LOWDAY")
    @Expose
    private val lowDay: Double? = null,

    @SerializedName("OPEN24HOUR")
    @Expose
    private val open24hour: Double? = null,

    @SerializedName("HIGH24HOUR")
    @Expose
    private val high24hour: Double? = null,

    @SerializedName("LOW24HOUR")
    @Expose
    private val low24hour: Double? = null,

    @SerializedName("LASTMARKET")
    @Expose
    private val lastMarket: String? = null,

    @SerializedName("VOLUMEHOUR")
    @Expose
    private val volumeHour: Double? = null,

    @SerializedName("VOLUMEHOURTO")
    @Expose
    private val volumeHourto: Double? = null,

    @SerializedName("OPENHOUR")
    @Expose
    private val openHour: Int? = null,

    @SerializedName("HIGHHOUR")
    @Expose
    private val highHour: Double? = null,

    @SerializedName("LOWHOUR")
    @Expose
    private val lowHour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    private val topTierVolume24hour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    private val topTierVolume24hourTo: Double? = null,

    @SerializedName("CHANGE24HOUR")
    @Expose
    private val change24hour: Double? = null,

    @SerializedName("CHANGEDAY")
    @Expose
    private val changeDay: Double? = null,

    @SerializedName("CHANGEHOUR")
    @Expose
    private val changeHour: Double? = null,

    @SerializedName("CONVERSIONTYPE")
    @Expose
    private val conversionType: String? = null,

    @SerializedName("CONVERSIONSYMBOL")
    @Expose
    private val conversionSymbol: String? = null,

    @SerializedName("SUPPLY")
    @Expose
    private val supply: Int? = null,

    @SerializedName("TOTALVOLUME24H")
    @Expose
    private val totalVolume24h: Double? = null,

    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    private val totalVolume24hto: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    private val totalTopTierVolume24h: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    private val totalTopTierVolume24hto: Double? = null,

    @SerializedName("IMAGEURL")
    @Expose
    private val imageUrl: String? = null
)