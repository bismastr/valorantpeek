package com.bismastr.myvalorant.ui.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bismastr.myvalorant.R;
import com.bismastr.myvalorant.data.local.entity.NewsEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView tvDate, tvTitle;
    CardView cvNews;
    ImageView ivNews;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        tvDate = itemView.findViewById(R.id.tv_date);
        tvTitle = itemView.findViewById(R.id.tv_title);
        cvNews = itemView.findViewById(R.id.cv_news);
        ivNews = itemView.findViewById(R.id.iv_news);

    }

    void bind(NewsEntity newsEntity){
        Glide.with(itemView.getContext())
                .load(newsEntity.getBannerUrl())
                .into(ivNews);
        tvDate.setText(newsEntity.getBannerUrl());
        tvTitle.setText(newsEntity.getTitle());
    }
}
