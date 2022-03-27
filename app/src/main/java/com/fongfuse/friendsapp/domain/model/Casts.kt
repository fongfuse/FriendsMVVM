package com.fongfuse.friendsapp.domain.model

data class Casts(
    val cast: List<Cast>
) {
    data class Cast(
        val name: String,
        val profilePath: String,
        val roles: Role
    ) {
        data class Role(val character: String)
    }
}