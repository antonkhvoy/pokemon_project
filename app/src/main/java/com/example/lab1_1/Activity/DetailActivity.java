package com.example.lab1_1.Activity;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab1_1.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("MyApp", "DetailActivity onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void onStart() {
        Log.w("MyApp", "DetailActivity onStart() called");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.w("MyApp", "DetailActivity onResume() called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.w("MyApp", "DetailActivity onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.w("MyApp", "DetailActivity onStop() called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.w("MyApp", "DetailActivity onDestroy() called");
        super.onDestroy();
    }
}
