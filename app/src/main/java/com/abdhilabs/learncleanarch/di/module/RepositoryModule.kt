package com.abdhilabs.learncleanarch.di.module

import com.abdhilabs.data.repository.SportRepositoryImpl
import com.abdhilabs.domain.sport.SportRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindSportRepository(repository: SportRepositoryImpl): SportRepository
}