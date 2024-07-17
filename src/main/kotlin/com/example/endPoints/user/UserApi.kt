package com.example.endPoints.user

import com.example.response.GetPetByID
import retrofit2.http.GET

interface UserApi {
    /**
     * Method implementation petstore.swagger-> GET /pet/{petId}
     * Найти питомца по petId
     */

    @GET("/pet/{petId}")
    fun getPetById(): GetPetByID
}