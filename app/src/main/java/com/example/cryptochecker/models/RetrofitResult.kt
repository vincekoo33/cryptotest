package com.example.cryptochecker.models

import com.example.cryptochecker.models.Status.*

class RetrofitResult<T : Any>(val status: Status, val response: T?, val error: String?) {

    companion object {
        fun <T : Any> success(data: T?): RetrofitResult<T> {
            return RetrofitResult(SUCCESS, data, null)
        }

        fun <T : Any> error(error: String, data: T?): RetrofitResult<T> {
            return RetrofitResult(ERROR, data, error)
        }
    }

}

sealed class Status {
    object SUCCESS : Status()
    object ERROR : Status()
}