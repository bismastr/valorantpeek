package com.bismastr.myvalorant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;

import com.bismastr.myvalorant.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Transition transition = new Fade();
                transition.setDuration(600);
                transition.addTarget(binding.llButton);
                TransitionManager.beginDelayedTransition(binding.getRoot(), transition);

                Log.d("wow", "mantab");

            }
        }, 3000);
    }
}