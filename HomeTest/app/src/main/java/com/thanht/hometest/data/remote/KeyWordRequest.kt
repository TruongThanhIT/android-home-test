package com.thanht.hometest.data.remote

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface KeyWordRequest {

    @GET("tikivn/android-home-test/v2/keywords.json")
    fun getKeyWords(): Observable<List<String>>

    companion object {
        fun create(): KeyWordRequest {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://raw.githubusercontent.com/")
                .build()

            return retrofit.create(KeyWordRequest::class.java)
        }
    }
}