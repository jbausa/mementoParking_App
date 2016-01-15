package com.tfg.jbausa.mementoparking;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openWebPage("http://mementoparking.herokuapp.com");
    }
    @Override
    public void onResume() {
        super.onResume();
        openWebPage("http://mementoparking.herokuapp.com");
    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}