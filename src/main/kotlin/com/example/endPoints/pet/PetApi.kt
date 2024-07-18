package com.example.endPoints.pet

import com.example.request.CreateNewPet
import com.example.request.DeletePet
import com.example.response.SuccessAddNewPetInStoreResponse
import com.example.response.GetPetByID
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

interface PetApi {
    /**
     * Method implementation petStore.swagger-> GET /pet/{petId}
     * Найти питомца по petId
     */
    @GET("pet/{petId}")
    fun findPetById(@Path("petId") petId: Int): Call<GetPetByID>

    /**
     * Method implementation petStore.swagger-> POST /pet/{petId}
     * Добавить нового питмца в Store
     */
    @POST("pet")
    fun addNewPetToTheStore(@Body pet: CreateNewPet): Call<SuccessAddNewPetInStoreResponse>

    /**
     * Method implementation petStore.swagger-> DELETE /pet/{petId}
     * Удалить нового питомца в Store
     */
    @DELETE("pet/{petId}")
    fun deleteCreatedPet(@Path("petId") petId: Int): Call<DeletePet>
}