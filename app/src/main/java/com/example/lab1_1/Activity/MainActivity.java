package com.example.lab1_1.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab1_1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("MyApp", "MainActivity onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.w("MyApp", "MainActivity onStart() called");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.w("MyApp", "MainActivity onResume() called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.w("MyApp", "MainActivity onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.w("MyApp", "MainActivity onStop() called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.w("MyApp", "MainActivity onDestroy() called");
        super.onDestroy();
    }

    public void openDetailActivity(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void openWebPage(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=J7UwSVsiwzI"));
        startActivity(intent);
    }

    public void openGooglePlayActivity(View view) {
        Intent intent = new Intent(this, GooglePlayActivity.class);
        startActivity(intent);
    }
}