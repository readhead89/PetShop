package com.example.request

data class PetRequest(
    val category: Category,
    val id: Int,
    val name: String,
    val photoUrls: List<String>,
    val status: String,
    val tags: List<Tag>
)