package com.example

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.charset.StandardCharsets

class LoggingInterceptor : Interceptor {

    private val logger: Logger = LoggerFactory.getLogger(LoggingInterceptor::class.java)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        // Логирование тела запроса

        val requestBody = request.body
        val requestBodyString = requestBody?.let {
            val buffer = Buffer()
            it.writeTo(buffer)
            buffer.readString(StandardCharsets.UTF_8)
        } ?: "No Request Body"
        logger.debug(
            "Sending request to method: {} this URL: {}  with body: {}",
            request.method,
            request.url,
            requestBodyString
        )

        val response = chain.proceed(request)

        // Логирование тела ответа
        val responseBody = response.body?.string() ?: "No Response Body"
        logger.debug(
            "Received response StatusCode: {} from {} with body: {}",
            response.code,
            response.request.url,
            responseBody
        )

        // Чтобы сохранить тело ответа для последующего использования, создаем новое тело
        return response.newBuilder()
            .body(responseBody.toResponseBody(response.body?.contentType()))
            .build()
    }
}