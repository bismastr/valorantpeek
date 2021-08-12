package com.bismastr.myvalorant.ui.news;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.bismastr.myvalorant.R;
import com.bismastr.myvalorant.data.Resource;
import com.bismastr.myvalorant.data.local.entity.NewsEntity;
import com.bismastr.myvalorant.data.remote.response.NewsItem;
import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private ArrayList<NewsEntity> newsList;
    private Context context;
    Resource<List<NewsEntity>> News;

    public NewsAdapter(ArrayList newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    void setNews(ArrayList<NewsEntity> data){
        newsList.clear();
        newsList.addAll(data);
        Log.d("ERROR", data.toString());
    }
}
