package com.bismastr.myvalorant.ui.news;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bismastr.myvalorant.R;
import com.bismastr.myvalorant.data.local.entity.NewsEntity;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private final List<NewsEntity> localDataSet;

    public NewsAdapter(List<NewsEntity> dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Log.d("HOLDER", localDataSet.get(0).toString());
        holder.bind(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
