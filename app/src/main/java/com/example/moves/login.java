package com.example.moves;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private TextInputLayout email, password;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.emailinlogin);
        password=findViewById(R.id.passwordinlogin);
        btnLogin=findViewById(R.id.Logininlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


    }
    private void login()
    {
        String user = email.getEditText().getText().toString().trim();
        String pass = password.getEditText().getText().toString().trim();
        if(user.isEmpty())
        {            email.setError("Email can not be empty");        }
        if(pass.isEmpty())
        {            password.setError("Password can not be empty");        }
        else
        {

            }    }


    }
