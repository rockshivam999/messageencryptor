package com.vssqure.chatroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void Register(View view) {
        startActivity(new Intent(StartActivity.this,RegisterActivity.class));
    }

    public void Login(View view) {
        startActivity(new Intent(StartActivity.this,Login.class));
    }
}
