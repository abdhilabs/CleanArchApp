package com.abdhilabs.learncleanarch.di.module

import com.abdhilabs.learncleanarch.presentation.sport.SportActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectionModule {

    @ContributesAndroidInjector
    abstract fun contributesSportActivity(): SportActivity
}