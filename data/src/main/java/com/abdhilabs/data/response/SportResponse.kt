package com.abdhilabs.data.response

import com.squareup.moshi.Json

data class SportResponse(
    @Json(name = "sports")
    val sports: List<Sport?>? = null
) {
    data class Sport(
        @Json(name = "idSport")
        val idSport: String? = null,
        @Json(name = "strFormat")
        val strFormat: String? = null,
        @Json(name = "strSport")
        val strSport: String? = null,
        @Json(name = "strSportDescription")
        val strSportDescription: String? = null,
        @Json(name = "strSportThumb")
        val strSportThumb: String? = null,
        @Json(name = "strSportThumbGreen")
        val strSportThumbGreen: String? = null
    )
}