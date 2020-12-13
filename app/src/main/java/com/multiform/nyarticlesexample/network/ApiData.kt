package com.multiform.nyarticlesexample.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiData(
    @Json(name = "status") val status: String,
    @Json(name = "results") val results: List<Result>
)

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "title") val title: String?,
    @Json(name = "url") val link: String?,
    @Json(name = "abstract") val subtitle: String?,
    @Json(name = "published_date") val datePublished: String?,
    @Json(name = "byline") val byAuthor: String?,
    @Json(name = "des_facet") val categories: List<String>?,
    @Json(name = "media") val media: List<Media>?
)

@JsonClass(generateAdapter = true)
data class Media(
    @Json(name = "media-metadata") val metadata: List<Images>?
)

@JsonClass(generateAdapter = true)
data class Images(
    @Json(name = "url") val imageUrl: String?
)