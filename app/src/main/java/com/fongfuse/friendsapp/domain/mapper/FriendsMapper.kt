package com.fongfuse.friendsapp.domain.mapper

import com.fongfuse.friendsapp.BuildConfig
import com.fongfuse.friendsapp.data.response.FriendsResponse
import com.fongfuse.friendsapp.domain.model.Friends
import java.text.SimpleDateFormat
import java.util.Date

fun FriendsResponse.toModel() = Friends(
    originalName = originalName.orEmpty(),
    overview = overview.orEmpty(),
    posterPath = BuildConfig.BASE_IMAGE_URL + posterPath,
    voteAverage = (voteAverage ?: 0.0).toString(),
    numberOfEpisodes = (numberOfEpisodes ?: 0).toString(),
    numberOfSeasons = (numberOfSeasons ?: 0).toString(),
    seasons = transformSeasonsToListModel(seasons ?: emptyList())
)

fun transformSeasonsToListModel(seasonList: List<FriendsResponse.Season>): List<Friends.Season> {
    return seasonList.map {
        Friends.Season(
            name = it.name.orEmpty(),
            posterPath = BuildConfig.BASE_IMAGE_URL + it.posterPath,
            episodeCount = it.episodeCount ?: 0,
            airDate = transformStringToDate(it.airDate ?: "0000-00-00"),
            overview = it.overview.orEmpty()
        )
    }
}

fun transformStringToDate(date: String): Date {
    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.parse(date)
}

