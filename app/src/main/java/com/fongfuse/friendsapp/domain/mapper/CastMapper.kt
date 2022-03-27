package com.fongfuse.friendsapp.domain.mapper

import com.fongfuse.friendsapp.BuildConfig
import com.fongfuse.friendsapp.data.response.CastResponse
import com.fongfuse.friendsapp.domain.model.Casts

fun CastResponse.toModel() = Casts(
    cast = transformCastToListModel(cast ?: emptyList())
)

fun transformCastToListModel(castList: List<CastResponse.Cast>): List<Casts.Cast> {
    val casts = arrayListOf<Casts.Cast>()
    castList.mapIndexed { index, cast ->
        if (index <= 5) { //max 5
            casts.add(
                Casts.Cast(
                    name = cast.name.orEmpty(),
                    profilePath = BuildConfig.BASE_IMAGE_URL + cast.profilePath,
                    roles = transformRoleToModel(cast.roles?.get(0))
                )
            )
        }
    }
    return casts
}

fun transformRoleToModel(role: CastResponse.Cast.Role?): Casts.Cast.Role {
    return Casts.Cast.Role(
        character = role?.character.orEmpty()
    )
}

