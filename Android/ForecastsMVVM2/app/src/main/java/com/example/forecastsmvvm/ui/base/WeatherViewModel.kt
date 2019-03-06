package com.example.forecastsmvvm.ui.base

import androidx.lifecycle.ViewModel
import com.example.forecastsmvvm.data.provider.UnitProvider
import com.example.forecastsmvvm.data.repository.ForecastRepository
import com.example.forecastsmvvm.internal.UnitSystem
import com.example.forecastsmvvm.internal.lazyDeferred

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}