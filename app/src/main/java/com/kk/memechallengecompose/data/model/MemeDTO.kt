package com.kk.memechallengecompose.data.model

data class MemeDTO(
    val id : String,
    val name : String,
    val url : String,
    val width : Int,
    val height : Int,
    val box_count : Int,
    val captions : Int
)