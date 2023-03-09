package com.kk.memechallengecompose.data.service

import com.kk.memechallengecompose.data.model.ResponseMemeDTO
import retrofit2.http.GET

interface ApiService {

    @GET("get_memes")
    suspend fun getMemes(): ResponseMemeDTO
}