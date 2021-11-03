package ru.skillfactory.rentateam.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class UsersResponse(

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("per_page")
    val perPage: Int,

    @field:SerializedName("total")
    val total: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("data")
    val users: List<UserResponse> = emptyList(),
)