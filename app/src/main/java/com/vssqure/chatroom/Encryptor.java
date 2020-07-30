package com.vssqure.chatroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Encryptor extends AppCompatActivity {
private EditText messege,okey;
private TextView encMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryptor);
        messege=(EditText)findViewById(R.id.messageTOEncrypt);
        encMessage=(TextView)findViewById(R.id.EncryptedMessage);
        okey=(EditText)findViewById(R.id.key);
    }

    public void Encrypt(View view) {
        String messagetoenc = messege.getText().toString();
        String key = okey.getText().toString();
        int intKey=Integer.parseInt(key);
        if(!TextUtils.isEmpty(messagetoenc)){

            String prMessege="";
            char ch;
            int lengthe=messagetoenc.length();
            for(int i=0;i<lengthe;i++){
             ch = messagetoenc.charAt(i);
             ch = (char) ((int)ch+intKey);
             prMessege +=ch;

            }
            encMessage.setText(prMessege);

        }else{
            Toast.makeText(Encryptor.this,"Please Input Message",Toast.LENGTH_LONG).show();
        }
    }
}
