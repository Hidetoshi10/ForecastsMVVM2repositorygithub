package com.example.forecastsmvvm.data.provider

import com.example.forecastsmvvm.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}