package com.rizki.cleanarch.di

import com.rizki.cleanarch.presentation.login.LoginViewModel
import com.rizki.cleanarch.presentation.posts.PostsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { PostsViewModel(get()) }

    viewModel { LoginViewModel(get()) }

    single { createGetPostsUseCase(get()) }

    single { createPostRepository(get()) }
}