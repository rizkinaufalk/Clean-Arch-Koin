package com.rizki.cleanarch.domain.model

import com.squareup.moshi.JsonClass


//TODO RK: DELETE MODEL
@JsonClass(generateAdapter = true)
data class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)