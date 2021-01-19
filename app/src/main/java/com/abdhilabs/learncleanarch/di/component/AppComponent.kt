package com.abdhilabs.learncleanarch.di.component

import com.abdhilabs.data.di.ApiModule
import com.abdhilabs.data.di.NetworkModule
import com.abdhilabs.learncleanarch.App
import com.abdhilabs.learncleanarch.di.module.*
import com.abdhilabs.learncleanarch.di.module.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityInjectionModule::class,
        FragmentInjectionModule::class,
        ContextModule::class,
        CoroutineDispatcherModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        NetworkModule::class,
        ApiModule::class
    ]
)
interface AppComponent {
    fun inject(instance: App)
}