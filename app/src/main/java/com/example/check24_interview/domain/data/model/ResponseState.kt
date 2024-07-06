package com.example.check24_interview.domain.data.model

import com.example.check24_interview.data.ApiDataModel
import com.example.check24_interview.data.Product

data class ResponseState (
    val isLoading: Boolean = true,
    val data: List<Product> = emptyList(),
    val error: String = ""
)