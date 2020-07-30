package com.vssqure.chatroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
 private FirebaseAuth user;
 private EditText loginEmail,loginPassword;
 private Button loginBtn;
 private ProgressDialog loginProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       user= FirebaseAuth.getInstance();
        loginEmail=(EditText)findViewById(R.id.LoginEmail);
        loginPassword=(EditText)findViewById(R.id.LoginPassword);
        loginProgress= new ProgressDialog(this);
        loginBtn=(Button)findViewById(R.id.Loginbtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String passwors = loginPassword.getText().toString();
                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(passwors)){
                    loginProgress.setTitle("LOgging In");
                    loginProgress.setMessage("Please Wait..");
                    loginProgress.show();
                    login(email,passwors);
                }else {
                    Toast.makeText(Login.this,"Please Fill Details Correctly",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void login(String email, String passwors) {
        user.signInWithEmailAndPassword(email,passwors).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    loginProgress.dismiss();
                    startActivity(new Intent(Login.this,MainActivity.class));
                    finish();
                }else{
                    loginProgress.dismiss();
                    Toast.makeText(Login.this,"Please Enter Details Correctly",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
