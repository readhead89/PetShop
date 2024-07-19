package com.example.exception

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import okhttp3.internal.http2.Http2Reader.Companion.logger
import org.slf4j.Logger
import org.slf4j.LoggerFactory

//class ServerErrorException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
//class ServerErrorException(message: String, val statusCode: Int, cause: Throwable? = null) : RuntimeException(message, cause)
class ServerErrorException(message: String, val statusCode: Int, val responseBody: String, cause: Throwable? = null) :
    RuntimeException(message, cause)

data class ErrorResponse(
    val code: Int,
    val type: String,
    val message: String
)

fun mapExceptionToErrorResponse(exception: ServerErrorException): ErrorResponse {
    val gson = Gson()
    return try {
        gson.fromJson(exception.responseBody, ErrorResponse::class.java)
    } catch (e: JsonSyntaxException) {
        ErrorResponse(exception.statusCode, "ParsingError", "Error parsing response body")
    }
}

val logger: Logger = LoggerFactory.getLogger("RequestExecutor")

fun <T> executeRequest(call: () -> T): T? {
    return try {
        call()
    } catch (ex: ServerErrorException) {
        if (ex.statusCode == 404) {
            logger.info("Expected 404 error: ${ex.message}")
            null // Возвращаем null, если ошибка 404 ожидаема
        } else {
            throw ex // Пробрасываем исключение дальше, если это не 404 ошибка
        }
    }
}