package org.mz.mzbi.logic.network

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "https://api.bilibili.com/"
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(Interceptor { chain -> //前置处理
        val request = chain.request().newBuilder().
        header("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 11_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.6 Safari/605.1.1")
            .header("Referer","https://www.bilibili.com/").cacheControl(CacheControl.Builder().noCache().noStore().build())
            .build()
        val response=chain.proceed(request)
        //后置处理
        return@Interceptor response

    }).build()
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    inline fun <reified T> create(): T = create(T::class.java)
}