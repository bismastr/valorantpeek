package com.bismastr.myvalorant.ui.leaderboard;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity;
import com.bismastr.myvalorant.databinding.FragmentLeaderboardBinding;
import com.bismastr.myvalorant.databinding.ItemLeaderboardBinding;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardViewHolder> {
    private List<LeaderboardEntity> leaderboardList;

    public LeaderboardAdapter(List<LeaderboardEntity> newList) {
        leaderboardList = newList;
    }



    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LeaderboardViewHolder(ItemLeaderboardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        holder.bind(leaderboardList.get(position));
    }

    @Override
    public int getItemCount() {
        return leaderboardList.size();
    }
}
