package com.example.endPoints.user

import com.example.request.CreateNewUser
import com.example.response.ShortResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    /**
     * Method implementation petstore.swagger-> POST /user
     * Создать нового пользователя
     */
    @POST("user")
    fun createNewUser(@Body user: CreateNewUser): Call<ShortResponse>
}