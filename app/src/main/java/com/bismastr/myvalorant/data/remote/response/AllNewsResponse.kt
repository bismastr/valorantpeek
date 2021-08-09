package com.bismastr.myvalorant.data.remote.response

data class AllNewsResponse(
	val data: List<NewsItem>,
	val status: String
)

data class NewsItem(
	val date: String,
	val banner_url: String,
	val category: String,
	val title: String,
	val url: String,
	val external_link: String
)

