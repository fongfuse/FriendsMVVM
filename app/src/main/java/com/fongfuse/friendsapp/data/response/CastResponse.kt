package com.fongfuse.friendsapp.data.response

import com.google.gson.annotations.SerializedName

data class CastResponse(
    @SerializedName("cast")
    val cast: List<Cast>?
) {
    data class Cast(
        @SerializedName("name")
        val name: String?,
        @SerializedName("profile_path")
        val profilePath: String?,
        @SerializedName("roles")
        val roles: List<Role>?
    ) {
        data class Role(
            @SerializedName("character")
            val character: String?
        )
    }

}