package com.fongfuse.friendsapp.data.response

import com.google.gson.annotations.SerializedName

data class FriendsResponse(
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Int?,
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int?,
    @SerializedName("seasons")
    val seasons: List<Season>?
) {
    data class Season(
        @SerializedName("name")
        val name: String?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("episode_count")
        val episodeCount: Int?,
        @SerializedName("air_date")
        val airDate: String?,
        @SerializedName("overview")
        val overview: String?
    )
}