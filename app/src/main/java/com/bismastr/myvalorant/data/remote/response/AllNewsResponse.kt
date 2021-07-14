package com.bismastr.myvalorant.data.remote.response

data class AllNewsResponse(
	val data: List<DataItem>,
	val status: String
)

data class DataItem(
	val date: String,
	val bannerUrl: String,
	val category: String,
	val title: String,
	val url: String,
	val externalLink: String
)

