package com.example.response

data class SuccessAddNewPetInStoreResponse(
    val id: Int,
    val category: Category,
    val name: String,
    val photoUrls: List<String>,
    val tags: List<Tag>,
    val status: String
) {
    data class Category(
        val id: Int,
        val name: String
    )

    data class Tag(
        val id: Int,
        val name: String
    )
}