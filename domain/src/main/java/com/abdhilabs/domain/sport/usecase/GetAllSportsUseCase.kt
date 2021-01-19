package com.abdhilabs.domain.sport.usecase

import com.abdhilabs.domain.abstraction.UseCase
import com.abdhilabs.domain.sport.SportRepository
import com.abdhilabs.domain.sport.model.Sport
import com.abdhilabs.domain.vo.Result
import javax.inject.Inject

class GetAllSportsUseCase @Inject constructor(private val repository: SportRepository) :
    UseCase<UseCase.None, Result<List<Sport>>>() {
    override suspend fun invoke(params: None): Result<List<Sport>> {
        return repository.getAllSports()
    }
}