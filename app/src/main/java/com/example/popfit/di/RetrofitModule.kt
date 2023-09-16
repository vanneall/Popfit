package com.example.popfit.di

import com.example.popfit.data.FruitRepository
import com.example.popfit.data.FruitRepositoryRetrofitImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideFruitRepositoryRetrofitImpl(retrofit: Retrofit) : FruitRepository {
        return retrofit.create(FruitRepositoryRetrofitImpl::class.java)
    }
}