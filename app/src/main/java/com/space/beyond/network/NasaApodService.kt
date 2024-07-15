package com.space.beyond.network

import com.space.beyond.modal.ApodResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface NasaApodService {
    @GET("planetary/apod")
    suspend fun getApod(
        @Query("api_key") apiKey: String
    ): ApodResponse
}