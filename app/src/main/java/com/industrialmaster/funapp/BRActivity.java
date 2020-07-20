package com.industrialmaster.funapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_br);
    }

    MyReceiver receiver;
    public void activate(View v){
        receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(receiver,filter);
        Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();
    }
    public void deactivate(View v){
        //receiver = new MyReceiver();

    }
}
