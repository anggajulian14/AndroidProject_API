package com.example.projectapi

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("surat")
    fun getSurat(): Call<APIResponse>
}
