package com.example.forecastsmvvm.ui.weather.current


import com.example.forecastsmvvm.data.provider.UnitProvider
import com.example.forecastsmvvm.data.repository.ForecastRepository

import com.example.forecastsmvvm.internal.lazyDeferred
import com.example.forecastsmvvm.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,

    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {


    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }



}
