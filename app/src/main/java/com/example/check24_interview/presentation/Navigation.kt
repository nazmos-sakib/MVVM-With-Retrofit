package com.example.check24_interview.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.check24_interview.common.EmptyProduct
import com.example.check24_interview.common.Screen
import com.example.check24_interview.data.Product
import com.example.check24_interview.presentation.product.details.ProductDetailsUI
import com.example.check24_interview.presentation.product.overview.Overview
import com.example.check24_interview.presentation.product.overview.OverviewViewModel
import javax.inject.Inject

@Composable
fun Navigation(modifier: Modifier = Modifier){

    //val viewModel = OverviewViewModel()
    val viewModel = hiltViewModel<OverviewViewModel>()


    var selectedProduct by remember {
        mutableStateOf(EmptyProduct())
    }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.overView.route){
        composable(Screen.overView.route) {
            Overview(
                viewModel = viewModel,
                modifier = Modifier
                    .fillMaxSize(),
                onItemClick = {
                    selectedProduct = it
                    navController.navigate(Screen.detailsView.route)
                }
            )
        }

        composable(Screen.detailsView.route) {
            ProductDetailsUI(
                product = selectedProduct,
                onAddToFavorite = {}
            )
        }

    }
}