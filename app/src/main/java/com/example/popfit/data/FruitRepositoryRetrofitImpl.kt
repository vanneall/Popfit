package com.example.popfit.data

import retrofit2.http.GET

interface FruitRepositoryRetrofitImpl : FruitRepository {

    @GET("api/fruit/all")
    override suspend fun getFruitInfo(): List<Fruit>

}