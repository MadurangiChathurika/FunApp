package com.industrialmaster.funapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }

    public void start(View v){
       Intent intent = new Intent(this,MyService.class);
       startService(intent);
    }

    public void stop(View v){
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);
    }
}
