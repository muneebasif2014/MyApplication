package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class registration extends AppCompatActivity {


    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    Button mButtonsignin;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        mTextUsername = (EditText)findViewById(R.id.email);
        mTextPassword = (EditText)findViewById(R.id.password);
        mTextCnfPassword = (EditText)findViewById(R.id.repassword);
        mButtonRegister = (Button)findViewById(R.id.btnsignup);
        mButtonsignin = (Button)findViewById(R.id.btnsignin);
        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        mButtonsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(registration.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        Toast.makeText(registration.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(registration.this,mainpage.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(registration.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(registration.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }*/
                perfotAuth();
            }
        });
    }

    private void perfotAuth() {
        String user = mTextUsername.getText().toString().trim();
        String pwd = mTextPassword.getText().toString().trim();
        String cnf_pwd = mTextCnfPassword.getText().toString().trim();
        if (!user.matches(emailPattern))
        {
            mTextUsername.setError("enter correct email");
            mTextUsername.requestFocus();

        }
        else if (pwd.isEmpty() || pwd.length()<6)
        {
            mTextUsername.setError("enter proper password");
            mTextUsername.requestFocus();
        }
        else if (!pwd.equals(cnf_pwd))
        {
            mTextCnfPassword.setError("password not matched");
            mTextCnfPassword.requestFocus();
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(user,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful())
                   {
                       Toast.makeText(registration.this,"regestraion sucessfull ",Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                       startActivity(intent);
                       sendUserTonextactivity();

                   }
                   else
                   {
                       Toast.makeText(registration.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }

    }

    private void sendUserTonextactivity() {
        Intent i = new Intent(registration.this,login.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
