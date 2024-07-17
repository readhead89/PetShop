package com.example.endPoints.pet

import com.example.response.AddNewPetInStore
import com.example.response.GetPetByID
import com.example.request.PetRequest
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface PetApi {

    /**
     * Method implementation petstore.swagger-> GET /pet/{petId}
     * Найти питомца по petId
     */
    @GET("pet/{petId}")
    fun findPetById(@Path("petId") petId: Int): Call<GetPetByID>

    /**
     * Method implementation petstore.swagger-> POST /pet/{petId}
     * Найти питомца по petId
     */
    @POST("/pet")
    fun addNewPetToTheStore(@Body petId: Int): Call<AddNewPetInStore>


}