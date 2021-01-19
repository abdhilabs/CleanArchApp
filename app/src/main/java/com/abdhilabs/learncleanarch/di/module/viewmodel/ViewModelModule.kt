package com.abdhilabs.learncleanarch.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdhilabs.learncleanarch.presentation.sport.SportViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SportViewModel::class)
    abstract fun provideSportViewModel(viewModel: SportViewModel): ViewModel
}