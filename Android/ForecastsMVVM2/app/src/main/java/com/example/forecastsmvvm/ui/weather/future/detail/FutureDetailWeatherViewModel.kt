package com.example.forecastsmvvm.ui.weather.future.detail

import com.example.forecastsmvvm.data.provider.UnitProvider
import com.example.forecastsmvvm.data.repository.ForecastRepository
import com.example.forecastsmvvm.internal.lazyDeferred
import com.example.forecastsmvvm.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate


class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
