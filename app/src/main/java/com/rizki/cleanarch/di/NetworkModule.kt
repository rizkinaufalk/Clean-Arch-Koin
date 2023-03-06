package com.rizki.cleanarch.di

import com.rizki.cleanarch.data.repository.LoginRepositoryImp
import com.rizki.cleanarch.data.source.remote.LoginService
import com.rizki.cleanarch.domain.repository.LoginRepository
import com.rizki.cleanarch.domain.usecase.DoLoginUseCase
import com.rizki.cleanarch.utils.Constant
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L

val NetworkModule = module {

    single { createService(get()) }

    single { createRetrofit(get(), Constant.BASE_URL) }

    single { createOkHttpClient() }

    single { MoshiConverterFactory.create() }

    single { Moshi.Builder().build() }

}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create()).build()
}

fun createService(retrofit: Retrofit): LoginService {
    return retrofit.create(LoginService::class.java)
}

fun createPostRepository(apiService: LoginService): LoginRepository {
    return LoginRepositoryImp(apiService)
}

fun createGetPostsUseCase(postsRepository: LoginRepository): DoLoginUseCase {
    return DoLoginUseCase(postsRepository)
}
