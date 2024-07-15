package com.space.beyond.appModule

import com.space.beyond.network.NasaApodService
import com.space.beyond.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideNasaApiService(retrofit: Retrofit): NasaApodService {
        return retrofit.create(NasaApodService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(nasaApiService: NasaApodService): Repository {
        return Repository(nasaApiService)
    }

}