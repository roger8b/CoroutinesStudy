package com.rms.coroutinesstudy.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class Todo(
    //@SerialName("userId") val userId: String,
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("completed") val completed: Boolean
)