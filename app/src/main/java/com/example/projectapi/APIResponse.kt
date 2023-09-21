package com.example.projectapi

import com.google.gson.annotations.SerializedName

data class APIResponse (
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<SuratResponse>
    )