package com.example.moves;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button singnup;
    Intent tomain;
    Handler handeler=new Handler(Looper.getMainLooper());
    MainActivity m=new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        e1=findViewById(R.id.usernameinsignup);
        e2=findViewById(R.id.passwordinsignup);
        singnup=findViewById(R.id.signupinsignup);
        tomain=new Intent(this,LoginAndSignup.class);
        singnup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==singnup){
            tomain.putExtra("intent1fromsignup",e1.getText().toString());
            tomain.putExtra("intent2fromsignup",e2.getText().toString());
            String edit1=e1.getText().toString();
            String edit2=e2.getText().toString();
            LoginAndSignup.array.add(edit1+edit2);
            Toast.makeText(SignUp.this, "hello", Toast.LENGTH_SHORT).show();
            handeler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LoginAndSignup.go=1;
                    startActivity(tomain);

                }
            },3000);

        }
    }


}