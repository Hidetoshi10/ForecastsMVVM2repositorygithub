package com.example.forecastsmvvm.ui.weather.future.list

import androidx.lifecycle.ViewModel;
import com.example.forecastsmvvm.data.provider.UnitProvider
import com.example.forecastsmvvm.data.repository.ForecastRepository
import com.example.forecastsmvvm.internal.lazyDeferred
import com.example.forecastsmvvm.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}
