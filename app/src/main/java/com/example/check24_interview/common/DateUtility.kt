package com.example.check24_interview.common

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
fun convertIntToTime(time: Int): String {
    val date = Date(time.toLong())
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.format(date)
}
