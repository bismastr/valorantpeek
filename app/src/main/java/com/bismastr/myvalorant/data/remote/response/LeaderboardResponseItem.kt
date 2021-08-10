package com.bismastr.myvalorant.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeaderboardResponseItem(

	@field:SerializedName("competitiveTier")
	val competitiveTier: Int,

	@field:SerializedName("numberOfWins")
	val numberOfWins: Int,

	@field:SerializedName("IsBanned")
	val isBanned: Boolean,

	@field:SerializedName("gameName")
	val gameName: String,

	@field:SerializedName("rankedRating")
	val rankedRating: Int,

	@field:SerializedName("PlayerCardID")
	val playerCardID: String,

	@field:SerializedName("leaderboardRank")
	val leaderboardRank: Int,

	@field:SerializedName("tagLine")
	val tagLine: String,

	@field:SerializedName("IsAnonymized")
	val isAnonymized: Boolean,

	@field:SerializedName("puuid")
	val puuid: String,

	@field:SerializedName("TitleID")
	val titleID: String
) : Parcelable