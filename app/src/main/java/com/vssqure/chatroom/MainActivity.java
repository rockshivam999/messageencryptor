package com.vssqure.chatroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

private FirebaseAuth user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user= FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = user.getCurrentUser();
        if(currentUser==null){
            startActivity(new Intent(MainActivity.this,StartActivity.class));
            finish();
        }
    }

    public void Logout(View view) {
        user.getInstance().signOut();
        startActivity(new Intent(MainActivity.this,StartActivity.class));
        finish();
    }

    public void Encrypt(View view) {
        startActivity(new Intent(MainActivity.this,Encryptor.class));
    }

    public void Decrypt(View view) {
        startActivity(new Intent(MainActivity.this,Decryptor.class));
    }
}
