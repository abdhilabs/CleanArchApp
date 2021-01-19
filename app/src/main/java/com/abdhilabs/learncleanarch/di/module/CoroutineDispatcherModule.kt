package com.abdhilabs.learncleanarch.di.module

import com.abdhilabs.data.dispatcher.CoroutineDispatcherProvider
import com.abdhilabs.data.dispatcher.DispatcherProvider
import dagger.Binds
import dagger.Module

@Module
interface CoroutineDispatcherModule {

    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider): DispatcherProvider
}