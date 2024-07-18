package com.example.endPoints.store

import com.example.response.GetPetByID
import retrofit2.http.GET

interface StoreApi {

    /**
     * Method implementation petstore. Swagger-> GET /store/inventory
     * получить статус
     */
    @GET("/store/inventory")
    fun getPetById(): GetPetByID
}