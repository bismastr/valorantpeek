package com.bismastr.myvalorant.ui.leaderboard;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity;
import com.bismastr.myvalorant.databinding.FragmentLeaderboardBinding;
import com.bismastr.myvalorant.databinding.ItemLeaderboardBinding;

public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
    private final ItemLeaderboardBinding binding;
    public LeaderboardViewHolder(@NonNull ItemLeaderboardBinding viewBinding) {

        super(viewBinding.getRoot());
        this.binding = viewBinding;


    }

    public void bind(LeaderboardEntity element) {
        int leaderboardRank = element.getLeaderboardRank();
        binding.tvGameName.setText(element.getGameName());
        binding.tvLeaderboardRank.setText(String.valueOf(leaderboardRank));
    }
}
