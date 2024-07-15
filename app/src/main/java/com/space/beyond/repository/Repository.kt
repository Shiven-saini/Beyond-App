package com.space.beyond.repository

import com.space.beyond.modal.ApodResponse
import com.space.beyond.network.NasaApodService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val nasaApodService: NasaApodService
) {

    suspend fun getApod(apiKey: String): ApodResponse {
        return nasaApodService.getApod(apiKey)
    }


}