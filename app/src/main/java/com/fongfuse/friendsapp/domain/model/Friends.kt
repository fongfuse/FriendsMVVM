package com.fongfuse.friendsapp.domain.model

import java.util.Date

data class Friends(
    val originalName: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: String,
    val numberOfEpisodes: String,
    val numberOfSeasons: String,
    val seasons: List<Season>
) {
    data class Season(
        val name: String,
        val posterPath: String,
        val episodeCount: Int,
        val airDate: Date,
        val overview: String
    )
}