package com.abdhilabs.data.service

import com.abdhilabs.data.response.SportResponse
import retrofit2.http.GET

interface ApiService {

    @GET("all_sports.php")
    suspend fun getAllSports(): SportResponse

}