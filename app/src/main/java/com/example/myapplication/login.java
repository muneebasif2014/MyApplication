package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mTextUsername = (EditText)findViewById(R.id.username1);
        mTextPassword = (EditText)findViewById(R.id.password1);
        mButtonLogin = (Button)findViewById(R.id.button_login);

        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(login.this,registration.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               permormlogin();

                 String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
/*
               Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    Intent HomePage = new Intent(login.this,mainpage.class);
                    startActivity(HomePage);
                }
                else
                {
                    Toast.makeText(login.this,"password incorrect",Toast.LENGTH_SHORT).show();
                }*/            }
        });
    }

    private void permormlogin() {

        String user = mTextUsername.getText().toString().trim();
        String pwd = mTextPassword.getText().toString().trim();

        if (!user.matches(emailPattern))
        {
            mTextUsername.setError("enter correct email");
            mTextUsername.requestFocus();

        }
        else if (pwd.isEmpty() || pwd.length()<6)
        {
            mTextUsername.setError("enter proper pasward");
            mTextUsername.requestFocus();
        }
        else
        {
            mAuth.signInWithEmailAndPassword(user,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(login.this,"registration successfull ",Toast.LENGTH_SHORT).show();
                        sendUserTonextactivity();
                    }
                    else
                    {
                        Toast.makeText(login.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void sendUserTonextactivity() {
        Intent i = new Intent(login.this,mainpage.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
