package com.bismastr.myvalorant.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.bismastr.myvalorant.R;
import com.bismastr.myvalorant.ui.news.NewsFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Fragment newsFragment = new NewsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_view_tag, newsFragment).commit();
    }
}