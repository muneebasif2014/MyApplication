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

    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);
        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(registration.this,login.class);
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
            mTextUsername.setError("enter proper pasward");
            mTextUsername.requestFocus();
        }
        else if (!pwd.equals(cnf_pwd))
        {
            mTextCnfPassword.setError("pasward not matched");
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
