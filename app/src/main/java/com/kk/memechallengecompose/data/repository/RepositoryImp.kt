package com.kk.memechallengecompose.data.repository

import com.kk.memechallengecompose.core.utils.ResponseHandler
import com.kk.memechallengecompose.data.mapper.toDomainModel
import com.kk.memechallengecompose.data.service.ApiService
import com.kk.memechallengecompose.domain.model.Meme
import com.kk.memechallengecompose.domain.repository.IRepository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val service: ApiService): IRepository {

    override suspend fun getMemes(): ResponseHandler<List<Meme>> {
        return try {
            ResponseHandler.Success(service.getMemes().data.memes.map {
                toDomainModel(
                    it.name,
                    it.url
                )
            })
        } catch (e : Exception){
            ResponseHandler.Error(e.message.toString())
        }
    }
}