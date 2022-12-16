package com.example.test_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Sign_Up extends AppCompatActivity {
TextView login;
EditText email,pass;
FirebaseAuth auth;
Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ImageView i=findViewById(R.id.line);
        i.setColorFilter(Color.BLACK);
        login=findViewById(R.id.login);
        btn=findViewById(R.id.Sign_up_btn);
        email=findViewById(R.id.Email_SignUp);





       pass=findViewById(R.id.password_SigUp);
        auth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Sign_Up.this,log_in.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    auth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Sign_Up.this, "succ", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(Sign_Up.this,log_in.class);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(Sign_Up.this, "end", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });





                }
                catch (Exception e)
                {
                    Toast.makeText(Sign_Up.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}