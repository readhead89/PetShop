package com.example.logger

import com.example.exception.ServerErrorException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LoggingInterceptor : Interceptor {

    private val logger: Logger = LoggerFactory.getLogger(LoggingInterceptor::class.java)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // Логирование тела запроса
        val requestBodyString = request.body?.let { body ->
            val buffer = Buffer()
            body.writeTo(buffer)
            buffer.readUtf8()
        } ?: "{}"

        logger.debug(
            """
    |--> ${request.method} ${request.url}
    |${requestBodyString}
    |--> END ${request.method}
    """.trimMargin()
        )

        val response = chain.proceed(request)

        // Логирование тела ответа
        val responseBody = response.body?.string() ?: "No Response Body"

        if (!response.isSuccessful) {
            val errorMessage =
                "Method ${response.request.method} ${response.request.url} returned error response code: ${response.code} and ${responseBody}"
            // logger.error(errorMessage)
            throw ServerErrorException(errorMessage, response.code, responseBody)
        }

        logger.debug(
            """
            |<-- ${response.code} ${request.url}
            |${responseBody}
            |<-- END HTTP
            """.trimMargin()
        )

        // Чтобы сохранить тело ответа для последующего использования, создаем новое тело
        return response.newBuilder()
            .body(responseBody.toResponseBody(response.body?.contentType()))
            .build()
    }
}