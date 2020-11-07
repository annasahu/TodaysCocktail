package com.example.todayscocktail.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

private val moshi = Moshi.Builder() //tradutor
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder() //linkou
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CocktailsApiService {
    @GET("filter.php?a=Alcoholic")
    suspend fun getAlcoholicCocktails(): CocktailsResponse

    @GET("filter.php?a=Non_Alcoholic")
    suspend fun getNonAlcoholicCocktails(): CocktailsResponse
}

object CocktailsApi {
    val retrofitService: CocktailsApiService by lazy {
        retrofit.create(CocktailsApiService::class.java)
    }
}