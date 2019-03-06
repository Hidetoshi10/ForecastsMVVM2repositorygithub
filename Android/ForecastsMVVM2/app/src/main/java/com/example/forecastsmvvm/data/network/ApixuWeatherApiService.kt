package com.example.forecastsmvvm.data.network

import com.example.forecastsmvvm.data.db.network.response.CurrentWeatherResponse
import com.example.forecastsmvvm.data.db.network.response.FutureWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "b36370261c5e4e2a9f655846192102"

//http://api.apixu.com/v1/current.json?key=b36370261c5e4e2a9f655846192102&q=Bangkok&Lang=en

interface ApixuWeatherApiService {

    @GET("current.json")
    fun getCurrentWeather(
        @Query("q") location: String,
        @Query("lang") languageCode: String = "en"

    ): Deferred<CurrentWeatherResponse>

    //http://api.apixu.com/v1/forecast.json?key=b36370261c5e4e2a9f655846192102&q=Min%20Buri&days=1
    @GET("forecast.json")
    fun getFureWeather(
        @Query("q") location: String,
        @Query("day") days:Int,
        @Query("lang") languageCode: String = "en"
    ): Deferred<FutureWeatherResponse>


    companion object{
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): ApixuWeatherApiService {
            val requestInterceptor = Interceptor{chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)

            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.apixu.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)


        }
    }
}