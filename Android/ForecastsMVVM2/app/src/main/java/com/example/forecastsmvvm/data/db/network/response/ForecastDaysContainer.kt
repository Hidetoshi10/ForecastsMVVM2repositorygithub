package com.example.forecastsmvvm.data.db.network.response

import com.example.forecastsmvvm.data.db.entity.FutureWeatherEntry
import com.google.gson.annotations.SerializedName

data class ForecastDaysContainer(
    @SerializedName("forecastay")
    val entries: List<FutureWeatherEntry>
)