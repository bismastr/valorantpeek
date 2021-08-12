package com.bismastr.myvalorant.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bismastr.myvalorant.R;
import com.bismastr.myvalorant.ui.news.NewsFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view_tag, NewsFragment.class, null)
                    .commit();
        }

    }
}