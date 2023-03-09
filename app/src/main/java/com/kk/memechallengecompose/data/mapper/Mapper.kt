package com.kk.memechallengecompose.data.mapper

import com.kk.memechallengecompose.domain.model.Meme

fun toDomainModel(
    name: String,
    url: String
) : Meme = Meme(name, url)