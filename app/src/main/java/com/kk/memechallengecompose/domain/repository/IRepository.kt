package com.kk.memechallengecompose.domain.repository

import com.kk.memechallengecompose.core.utils.ResponseHandler
import com.kk.memechallengecompose.domain.model.Meme

interface IRepository {
    suspend fun getMemes(): ResponseHandler<List<Meme>>
}