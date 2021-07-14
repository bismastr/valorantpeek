package com.bismastr.myvalorant.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserMmrResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class E1a2(

	@field:SerializedName("wins")
	val wins: Int? = null,

	@field:SerializedName("act_rank_wins")
	val actRankWins: List<ActRankWinsItem?>? = null,

	@field:SerializedName("final_rank_patched")
	val finalRankPatched: String? = null,

	@field:SerializedName("number_of_games")
	val numberOfGames: Int? = null,

	@field:SerializedName("final_rank")
	val finalRank: Int? = null
)

data class E2a2(

	@field:SerializedName("wins")
	val wins: Int? = null,

	@field:SerializedName("act_rank_wins")
	val actRankWins: List<ActRankWinsItem?>? = null,

	@field:SerializedName("final_rank_patched")
	val finalRankPatched: String? = null,

	@field:SerializedName("number_of_games")
	val numberOfGames: Int? = null,

	@field:SerializedName("final_rank")
	val finalRank: Int? = null
)

data class E1a3(

	@field:SerializedName("wins")
	val wins: Int? = null,

	@field:SerializedName("act_rank_wins")
	val actRankWins: List<ActRankWinsItem?>? = null,

	@field:SerializedName("final_rank_patched")
	val finalRankPatched: String? = null,

	@field:SerializedName("number_of_games")
	val numberOfGames: Int? = null,

	@field:SerializedName("final_rank")
	val finalRank: Int? = null
)

data class E2a3(

	@field:SerializedName("wins")
	val wins: Int? = null,

	@field:SerializedName("act_rank_wins")
	val actRankWins: List<ActRankWinsItem?>? = null,

	@field:SerializedName("final_rank_patched")
	val finalRankPatched: String? = null,

	@field:SerializedName("number_of_games")
	val numberOfGames: Int? = null,

	@field:SerializedName("final_rank")
	val finalRank: Int? = null
)

data class BySeason(

	@field:SerializedName("e3a1")
	val e3a1: E3a1? = null,

	@field:SerializedName("e2a2")
	val e2a2: E2a2? = null,

	@field:SerializedName("e1a3")
	val e1a3: E1a3? = null,

	@field:SerializedName("e2a3")
	val e2a3: E2a3? = null,

	@field:SerializedName("e1a1")
	val e1a1: E1a1? = null,

	@field:SerializedName("e2a1")
	val e2a1: E2a1? = null,

	@field:SerializedName("e1a2")
	val e1a2: E1a2? = null
)

data class ActRankWinsItem(

	@field:SerializedName("tier")
	val tier: Int? = null,

	@field:SerializedName("patched_tier")
	val patchedTier: String? = null
)

data class E3a1(

	@field:SerializedName("wins")
	val wins: Int? = null,

	@field:SerializedName("act_rank_wins")
	val actRankWins: List<ActRankWinsItem?>? = null,

	@field:SerializedName("final_rank_patched")
	val finalRankPatched: String? = null,

	@field:SerializedName("number_of_games")
	val numberOfGames: Int? = null,

	@field:SerializedName("final_rank")
	val finalRank: Int? = null
)

data class E1a1(

	@field:SerializedName("wins")
	val wins: Int? = null,

	@field:SerializedName("act_rank_wins")
	val actRankWins: List<ActRankWinsItem?>? = null,

	@field:SerializedName("final_rank_patched")
	val finalRankPatched: String? = null,

	@field:SerializedName("number_of_games")
	val numberOfGames: Int? = null,

	@field:SerializedName("final_rank")
	val finalRank: Int? = null
)

data class E2a1(

	@field:SerializedName("wins")
	val wins: Int? = null,

	@field:SerializedName("act_rank_wins")
	val actRankWins: List<ActRankWinsItem?>? = null,

	@field:SerializedName("final_rank_patched")
	val finalRankPatched: String? = null,

	@field:SerializedName("number_of_games")
	val numberOfGames: Int? = null,

	@field:SerializedName("final_rank")
	val finalRank: Int? = null
)

data class Data(

	@field:SerializedName("by_season")
	val bySeason: BySeason? = null,

	@field:SerializedName("current_data")
	val currentData: CurrentData? = null
)

data class CurrentData(

	@field:SerializedName("mmr_change_to_last_game")
	val mmrChangeToLastGame: Int? = null,

	@field:SerializedName("currenttierpatched")
	val currenttierpatched: String? = null,

	@field:SerializedName("ranking_in_tier")
	val rankingInTier: Int? = null,

	@field:SerializedName("elo")
	val elo: Int? = null,

	@field:SerializedName("games_needed_for_rating")
	val gamesNeededForRating: Int? = null,

	@field:SerializedName("currenttier")
	val currenttier: Int? = null
)
