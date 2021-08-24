package com.bismastr.myvalorant.ui.news;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bismastr.myvalorant.R;
import com.bismastr.myvalorant.data.local.entity.NewsEntity;
import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    void bind(NewsEntity newsEntity) {

        String dateStr = newsEntity.getDate().toString(); //"2020-04-15T18:00:00.000Z"
        String title = newsEntity.getTitle();
        String bannerUrl = newsEntity.getBannerUrl();
        String url = newsEntity.getUrl();
        String category = newsEntity.getCategory();

        // image
        Glide.with(itemView.getContext())
                .load(bannerUrl)
                .into(ivNews);

        // date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'", Locale.ENGLISH);
        try {
            Date parsedDate = dateFormat.parse(dateStr);
            SimpleDateFormat print = new SimpleDateFormat("dd/MM/yyyy");
            if (parsedDate != null) {
                tvDate.setText(print.format(parsedDate));
            }
        } catch (ParseException e) {
            Log.d("ERROR", e.toString());
        }

        // title
        tvTitle.setText(title);

        // external url
        Uri uri = Uri.parse(url);
        cvNews.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            itemView.getContext().startActivity(intent);
        });

    }
}
