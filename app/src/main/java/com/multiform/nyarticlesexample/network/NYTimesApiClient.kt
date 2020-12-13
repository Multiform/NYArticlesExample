package com.multiform.nyarticlesexample.network

import com.multiform.nyarticlesexample.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NYTimesApiClient {

    private const val BASE_URL = "https://api.nytimes.com/svc/"

    private const val API_KEY = "4q0FQsowQGp8DQ79Dmr7rKVNPOejGRvF"

    private val apiClient: NYTimesApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return@lazy retrofit.create(NYTimesApiService::class.java)
    }

    suspend fun getOneDayArticlesList(): List<Article> {
        return withContext(Dispatchers.IO) {
            apiClient.getOneDayArticlesList(API_KEY)
                .results
                .mapping()
        }
    }

    suspend fun getSevenDaysArticlesList(): List<Article> {
        return withContext(Dispatchers.IO) {
            apiClient.getSevenDaysArticlesList(API_KEY)
                .results
                .mapping()
        }
    }

    suspend fun getThirtyDaysArticlesList(): List<Article> {
        return withContext(Dispatchers.IO) {
            apiClient.getThirtyDaysArticlesList(API_KEY)
                .results
                .mapping()
        }
    }

    private fun List<Result>.mapping(): List<Article> {
        return this.map {
            with(it) {
                Article(
                    title,
                    link,
                    subtitle,
                    categories,
                    datePublished,
                    byAuthor,
//                    media?.first()?.metadata?.last()?.imageUrl
                ""
                )
            }
        }
    }
}