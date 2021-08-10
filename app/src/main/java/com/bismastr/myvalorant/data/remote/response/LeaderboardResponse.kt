package com.bismastr.myvalorant.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeaderboardResponse(

	@field:SerializedName("LeaderboardResponse")
	val leaderboardResponse: List<LeaderboardResponseItem>
) : Parcelable