package com.example.check24_interview.common

import com.example.check24_interview.data.Price
import com.example.check24_interview.data.Product

fun EmptyProduct():Product{
    return Product(
         available  = false,
     color  = "",
     colorCode = "",
     description = "",
     id = 0,
     imageURL = "",
     longDescription = "",
     name = "",
     price = Price("$",0.0),
     rating = 0.0,
     releaseDate = 0,
     type = ""
    )
}