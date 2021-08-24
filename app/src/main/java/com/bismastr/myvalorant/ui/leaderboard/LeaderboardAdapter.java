package com.bismastr.myvalorant.ui.leaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bismastr.myvalorant.R;
import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity;
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
        TextView tvNumber = holder.itemView.findViewById(R.id.tv_number);
        tvNumber.setText(String.valueOf(position + 1));

//        final boolean[] isExpanded = {leaderboardList.get(position).getExpanded()};
        boolean[] isExpanded = new boolean[leaderboardList.size()];
        isExpanded[position] = false;

        RelativeLayout expandableLayout = holder.itemView.findViewById(R.id.rl_expanded);
        expandableLayout.setVisibility(isExpanded[position] ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v -> {
//            LeaderboardEntity leaderboardEntity = leaderboardList.get(position);
//            isExpanded[position] = true;
//            notifyDataSetChanged();
            Toast.makeText(holder.itemView.getContext(), leaderboardList.get(position).getGameName(), Toast.LENGTH_LONG).show();
            isExpanded[position] = true;
            expandableLayout.setVisibility(isExpanded[position] ? View.VISIBLE : View.GONE);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return leaderboardList.size();
    }
}
