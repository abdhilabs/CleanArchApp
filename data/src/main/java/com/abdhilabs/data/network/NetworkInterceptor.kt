package com.abdhilabs.data.network

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain
            .request()
            .newBuilder()
            .addHeader("Accept", "application/json")
//            .addHeader("Authorization", "Bearer ${securePref.secureToken}")
            .build()

        return chain.proceed(newRequest)
    }

}