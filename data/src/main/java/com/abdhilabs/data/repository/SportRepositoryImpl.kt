package com.abdhilabs.data.repository

import com.abdhilabs.data.dispatcher.CoroutineDispatcherProvider
import com.abdhilabs.data.mapper.SportResultMapper
import com.abdhilabs.data.source.AppRemoteDataSource
import com.abdhilabs.domain.sport.SportRepository
import com.abdhilabs.domain.sport.model.Sport
import com.abdhilabs.domain.vo.Result
import javax.inject.Inject

class SportRepositoryImpl @Inject constructor(
    private val remoteDataSource: AppRemoteDataSource,
    private val dispatcher: CoroutineDispatcherProvider,
    private val sportResultMapper: SportResultMapper
) : SportRepository {
    override suspend fun getAllSports(): Result<List<Sport>> {
        val apiResult = remoteDataSource.getAllSports(dispatcher.io)
        return when (apiResult) {
            is Result.Success -> Result.Success(sportResultMapper.map(apiResult.data))
            is Result.Error -> Result.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
            else -> Result.Error()
        }
    }
}