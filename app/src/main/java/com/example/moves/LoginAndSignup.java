package com.example.moves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class LoginAndSignup extends AppCompatActivity {
    Button login ;
    EditText e,e2;
    Intent tohome,tosignup;
    ImageView help;
    public static int go=0;
    String toarry;
    public static ArrayList<String>array=new ArrayList<>();
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_signup);

        login = findViewById(R.id.butto);
        tohome=new Intent(this,MainActivity.class);
        tosignup=new Intent(this,SignUp.class);
        e = findViewById(R.id.usernameinmain);
        e2 = findViewById(R.id.passwordnameinmain);
        t=findViewById(R.id.Signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check=false;
                String checkpass=e.getText().toString()+e2.getText().toString();
                for(int i=0;i<array.size();i++){
                    if(array.get(i).equalsIgnoreCase(checkpass)){
                        check=true;
                        break;
                    }
                }
                if(check) {

                    startActivity(tohome);
                }
                else{
                    Toast.makeText(LoginAndSignup.this,"infalid", Toast.LENGTH_LONG).show();
                }

            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tosignup);
            }
        });
        if(go==1) {
            Intent fromsignup = getIntent();
            Toast.makeText(this, array.toString(), Toast.LENGTH_LONG).show();
        }
    }





}
