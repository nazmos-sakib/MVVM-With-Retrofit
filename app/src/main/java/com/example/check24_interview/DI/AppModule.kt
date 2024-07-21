package com.example.check24_interview.DI

import com.example.check24_interview.common.Constant.BASE_URL
import com.example.check24_interview.data.ApiService
import com.example.check24_interview.presentation.product.overview.OverviewViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {
    @Provides
    fun provideOverViewModel(api:ApiService):OverviewViewModel{
        return OverviewViewModel(api)
    }


    @Provides
    fun provideApiService():ApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}