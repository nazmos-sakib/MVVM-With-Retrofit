package com.example.check24_interview.common

sealed class Screen(val route:String) {
    object overView:  Screen("overview")
    object detailsView:  Screen("details")
}