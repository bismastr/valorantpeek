package com.bismastr.myvalorant.ui.leaderboard;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity;
import com.bismastr.myvalorant.databinding.ItemLeaderboardBinding;

public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
    private final ItemLeaderboardBinding binding;

    public LeaderboardViewHolder(@NonNull ItemLeaderboardBinding viewBinding) {
        super(viewBinding.getRoot());
        this.binding = viewBinding;
    }

    public void bind(LeaderboardEntity element) {
        int leaderboardRank = element.getLeaderboardRank();

        // nickname
        binding.tvGameName.setText(element.getGameName());
        binding.tvGameTag.setText("#" + element.getTagLine());

        // rating
        binding.tvRating.setText(element.getRankedRating() + " ");

        // match won
        binding.tvMatchWon.setText(element.getNumberOfWins() + " ");
    }
}
