package com.abdhilabs.domain.sport

import com.abdhilabs.domain.sport.model.Sport
import com.abdhilabs.domain.vo.Result

interface SportRepository {
    suspend fun getAllSports(): Result<List<Sport>>
}