package com.abdhilabs.data.source

import com.abdhilabs.data.response.SportResponse
import com.abdhilabs.data.service.ApiService
import com.abdhilabs.domain.vo.Result
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class AppRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    RemoteDataSource() {

    suspend fun getAllSports(dispatcher: CoroutineDispatcher): Result<SportResponse> {
        return safeApiCall(dispatcher) { apiService.getAllSports() }
    }

}