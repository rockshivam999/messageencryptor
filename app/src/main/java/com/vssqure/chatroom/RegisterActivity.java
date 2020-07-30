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

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth user;
    private EditText regEmail,regPassword;
    private ProgressDialog progressDialog;
    private Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user=FirebaseAuth.getInstance();
        regEmail=(EditText)findViewById(R.id.RegisterEmail);
        regPassword=(EditText)findViewById(R.id.RegisterPassword);
        Register=(Button)findViewById(R.id.RegisterButton);
        progressDialog=new ProgressDialog(this);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();
                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)){
                    progressDialog.setTitle("Registering");
                    progressDialog.setMessage("Processing");
                    progressDialog.show();
                    Register(email,password);

                }else {
                    Toast.makeText(RegisterActivity.this,"Please Enter Details Correctly",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void Register(String email, String password) {
        user.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    finish();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, "Please Enter Details Correctly",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
