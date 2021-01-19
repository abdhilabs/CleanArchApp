package com.abdhilabs.learncleanarch

import android.app.Application
import com.abdhilabs.data.di.NetworkModule
import com.abdhilabs.learncleanarch.di.component.AppComponent
import com.abdhilabs.learncleanarch.di.component.DaggerAppComponent
import com.abdhilabs.learncleanarch.di.module.ContextModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class App: Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent


    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        initAppDI()
        initTimber()
    }

    private fun initAppDI() {
        appComponent = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .networkModule(NetworkModule())
            .build()
        appComponent.inject(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    open fun getComponent(): AppComponent {
        return appComponent
    }
}