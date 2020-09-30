package com.rms.coroutinesstudy.request

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.*
import retrofit2.http.GET
import retrofit2.http.Path

fun main() = runBlocking {

    var client: WebServiceUsingCoroutines = configureRetrofit().create(WebServiceUsingCoroutines::class.java)
    try {
        val todo = client.getTodo(1)
        println(todo)
    } catch (e: HttpException){
        println(e.message())
    }
}

private fun callWebServiceUsingCallBack() {
    val client: WebServiceUsingCallback = configureRetrofit().create(WebServiceUsingCallback::class.java)
    client.getTodo(1).enqueue(object : Callback<Todo> {
        override fun onFailure(call: Call<Todo>, t: Throwable) {
            println("[onFailure] $call ${t.message}")
        }

        override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
            println("[onResponse] $call $response")
        }

    })
}

interface WebServiceUsingCoroutines {
    @GET("todos/{id}")
    suspend fun getTodo(@Path(value = "id") todoId: Int): Todo
}

interface WebServiceUsingCallback {
    @GET("todos/{id}")
    fun getTodo(@Path(value = "id") todoId: Int): Call<Todo>
}

fun configureRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(getJson().asConverterFactory(getContentType()))
    .build()

private fun getContentType() = MediaType.get(JSON_MEDIA_TYPE)

private fun getJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
}


private const val JSON_MEDIA_TYPE = "application/json"