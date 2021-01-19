package com.abdhilabs.data.mapper

import com.abdhilabs.data.abstraction.Mapper
import com.abdhilabs.data.response.SportResponse
import com.abdhilabs.domain.sport.model.Sport
import javax.inject.Inject

class SportResultMapper @Inject constructor() : Mapper<SportResponse, List<Sport>>() {

    override fun map(input: SportResponse): List<Sport> {
        return input.sports?.map {
            Sport(
                it?.idSport ?: "",
                it?.strFormat ?: "",
                it?.strSport ?: "",
                it?.strSportDescription ?: "",
                it?.strSportThumb ?: ""
            )
        } ?: emptyList()
    }
}