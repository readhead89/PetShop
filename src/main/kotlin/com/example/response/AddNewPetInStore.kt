package com.example.response

data class AddNewPetInStore(
    val category: CategoryX,
    val id: Int,
    val name: String,
    val photoUrls: List<String>,
    val status: String,
    val tags: List<TagX>
)