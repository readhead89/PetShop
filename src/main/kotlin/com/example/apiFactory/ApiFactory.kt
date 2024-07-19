package com.example.apiFactory

import com.example.logger.LoggingInterceptor
import com.example.endPoints.pet.PetApi
import com.example.endPoints.store.StoreApi
import com.example.endPoints.user.UserApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://petstore.swagger.io/v2/"

object ApiFactory {
    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(LoggingInterceptor())
        .build()

    private var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    val petApi: PetApi = retrofit.create(PetApi::class.java)
    val storeApi: StoreApi = retrofit.create(StoreApi::class.java)
    val userApi: UserApi = retrofit.create(UserApi::class.java)
}