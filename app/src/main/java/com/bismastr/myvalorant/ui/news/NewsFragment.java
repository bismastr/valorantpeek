package com.bismastr.myvalorant.ui.news;

import static org.koin.android.compat.ViewModelCompat.viewModel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bismastr.myvalorant.data.Resource;
import com.bismastr.myvalorant.data.local.entity.NewsEntity;
import com.bismastr.myvalorant.databinding.FragmentNewsBinding;

import java.util.ArrayList;
import java.util.List;


import kotlin.Lazy;


public class NewsFragment extends Fragment {

    private ArrayList newsList = new ArrayList();
    //private NewsViewModel newsViewModel;
    private NewsAdapter newsAdapter;
    private FragmentNewsBinding binding;

    // lazy ViewModel
    private final Lazy<NewsViewModel> newsViewModel = viewModel(this, NewsViewModel.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        showRecyclerList();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getNews() {
        final Observer<Resource<List<NewsEntity>>> newsObserver = new Observer<Resource<List<NewsEntity>>>() {
            @Override
            public void onChanged(Resource<List<NewsEntity>> NewsResource) {
                if (NewsResource.getData() != null) {
                    if (NewsResource == Resource.Loading) {
                        Log.d("RESOURCE", "Loading!");
                    } if (NewsResource == Resource.Success) {
                        Log.d("RESOURCE", "Success LUR!");
                        ArrayList newsArraylist = (ArrayList) NewsResource.getData();
                        newsAdapter.setNews(newsArraylist);
                    } if (NewsResource == Resource.Error) {
                        Log.d("RESOURCE", "Error!");
                    }
                }
            }
        };
        newsViewModel.getValue().getGetAllNews().observe(getViewLifecycleOwner(), newsObserver);
    }

    private void showRecyclerList() {
        binding.rvLatestNews.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.rvLatestNews.setAdapter(newsAdapter);
        getNews();
    }
}