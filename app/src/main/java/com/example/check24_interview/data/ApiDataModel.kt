package com.example.check24_interview.data

data class ApiDataModel(
    val filters: List<String>,
    val header: Header,
    val products: List<Product>
)