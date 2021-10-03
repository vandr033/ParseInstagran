package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    private EditText etUsernameSU;
    private EditText etPasswordSU;
    private Button btnSignupSU;
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etPasswordSU = findViewById(R.id.etPasswordSU);
        etUsernameSU = findViewById(R.id.etUsernameSU);
        btnSignupSU = findViewById(R.id.btnSignUpSU);
        username = etUsernameSU.getText().toString();
        password = etPasswordSU.getText().toString();

        btnSignupSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUP(username, password);
            }
        });


    }

    private void signUP(String username, String password){

            // Create the ParseUser
            ParseUser user = new ParseUser();
            // Set core properties
            if(etUsernameSU.getText().toString().isEmpty()){
                Toast.makeText(SignUpActivity.this, "You must have a valid username", Toast.LENGTH_SHORT).show();
            }else {
                user.setUsername(etUsernameSU.getText().toString());
            }
            if(etPasswordSU.getText().toString().isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Your password cannot be empty", Toast.LENGTH_SHORT).show();
            }else{
                user.setPassword(etPasswordSU.getText().toString());
            }
            // Invoke signUpInBackground
            user.signUpInBackground(new SignUpCallback() {

                public void done(ParseException e) {
                    if (e == null) {
                        Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Log.e(TAG, "Sign up did not succeed", e);
                    }
                }
            });

        }
    }