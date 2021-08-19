package com.bismastr.myvalorant.ui.leaderboard;

import static org.koin.android.compat.SharedViewModelCompat.sharedViewModel;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bismastr.myvalorant.R;
import com.bismastr.myvalorant.data.local.entity.LeaderboardEntity;
import com.bismastr.myvalorant.databinding.FragmentLeaderboardBinding;

import java.util.List;

import kotlin.Lazy;

public class LeaderboardFragment extends Fragment {
    private FragmentLeaderboardBinding binding;
    //viewmodel
    private final Lazy<LeaderboardViewModel> viewModel = sharedViewModel(this, LeaderboardViewModel.class);
    //adapter
    private LeaderboardAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeaderboardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLeaderboard();
    }

    private void getLeaderboard() {
        viewModel.getValue().getGetLeaderboard().observe(requireActivity(), LeaderboardList -> {
            Log.d("GETNEWS", "INIT");

            if (LeaderboardList.getData() != null) {
                showRecyclerList(LeaderboardList.getData());
                Log.d("Get Leaderboard", LeaderboardList.getData().toString());

            } else {
                Log.d("Get Leaderboard", "Null");
            }

        });
    }

    private void showRecyclerList(List<LeaderboardEntity> data) {
        adapter = new LeaderboardAdapter(data);
        binding.rvLeaderboard.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.rvLeaderboard.setAdapter(adapter);

    }
}