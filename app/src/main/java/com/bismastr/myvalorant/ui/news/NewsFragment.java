package com.bismastr.myvalorant.ui.news;

import static org.koin.android.compat.SharedViewModelCompat.sharedViewModel;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bismastr.myvalorant.data.local.entity.NewsEntity;
import com.bismastr.myvalorant.databinding.FragmentNewsBinding;

import java.util.List;

import kotlin.Lazy;


public class NewsFragment extends Fragment {
    private FragmentNewsBinding binding;
    // lazy ViewModel
    private final Lazy<NewsViewModel> viewModel = sharedViewModel(this, NewsViewModel.class);


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        getNews();
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getNews() {
        viewModel.getValue().getGetAllNews().observe(requireActivity(), NewsList -> {
            Log.d("GETNEWS", "INIT");

            if (NewsList.getData() != null) {
                showRecyclerList(NewsList.getData());
                Log.d("GETNEWS", NewsList.getData().toString());

            } else {
                Log.d("GETNEWS", "Null");
            }

        });
    }

    private void showRecyclerList(List<NewsEntity> data) {
        NewsAdapter newsAdapter = new NewsAdapter(data);
        binding.rvLatestNews.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.rvLatestNews.setAdapter(newsAdapter);
    }
}