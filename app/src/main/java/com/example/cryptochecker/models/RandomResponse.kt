package com.example.cryptochecker.models

import com.google.gson.annotations.SerializedName

data class RandomResponse(@SerializedName("_id") val id: String?,
                          @SerializedName("quoteText") val quoteText: String?,
                          @SerializedName("quoteAuthor") val quoteAuthor: String?)


