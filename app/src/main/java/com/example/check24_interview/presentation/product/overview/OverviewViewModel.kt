package com.example.check24_interview.presentation.product.overview


import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24_interview.data.ApiService
import com.example.check24_interview.domain.data.model.ResponseState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OverviewViewModel() : ViewModel () {
    //state solution ------
    private val _state = mutableStateOf(ResponseState())
    val state: State<ResponseState>
        get()  = _state
    //state end

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            try {
                val temp = ApiService.getInstance().getDataFromApi()
                Log.d("<<TAG>>", "apiData: $temp")
                delay(3000L)
                _state.value = ResponseState(
                    isLoading = false,
                    data = temp.products,
                    error = ""
                )
            } catch (e:Exception){
                Log.d("<<TAG>>", "getData: ${e.message}")
                _state.value = ResponseState(
                    isLoading = false,
                    error = e.message?:""
                )

            }
        }
    }
}