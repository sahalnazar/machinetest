package com.sahalnazar.swiggymachinetest.di

import com.sahalnazar.swiggymachinetest.data.remote.ObdmService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(
                "application/json; charset=UTF8".toMediaType()))
            .baseUrl("http://www.omdbapi.com/")
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideApiService(
        retrofit: Retrofit
    ): ObdmService {
        return retrofit.create(ObdmService::class.java)
    }

}