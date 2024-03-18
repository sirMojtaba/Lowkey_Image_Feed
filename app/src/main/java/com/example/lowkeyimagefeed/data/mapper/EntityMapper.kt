package com.example.lowkeyimagefeed.data.mapper

import com.example.lowkeyimagefeed.data.source.local.entity.PhotoEntity
import com.example.lowkeyimagefeed.data.source.local.entity.SrcEntity
import com.example.lowkeyimagefeed.domain.Photo
import com.example.lowkeyimagefeed.domain.Src

fun Photo.toEntity(): PhotoEntity {
    return PhotoEntity(
        id = id,
        photographer = photographer,
        alt = alt,
        src = src.toEntity()
    )
}

fun PhotoEntity.toPhoto(): Photo {
    return Photo(
        id = id,
        photographer = photographer,
        alt = alt,
        src = src.toSrc()
    )
}

fun Src.toEntity(): SrcEntity {
    return SrcEntity(
        id = id,
        large = large,
        large2x = large2x
    )
}

fun SrcEntity.toSrc(): Src {
    return Src(
        id = id,
        large = large,
        large2x = large2x
    )
}