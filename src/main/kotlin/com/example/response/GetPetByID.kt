package com.example.response

data class GetPetByID(
    val category: Category,
    val id: Int,
    val name: String,
    val photoUrls: List<String>,
    val status: String,
    val tags: List<Tag>
)