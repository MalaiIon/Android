package com.example.rayca.my_application_lab_5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_welcome);

        boolean isLoggedIn = App.checkAuth();
        //true
        if ( isLoggedIn ) {
            startHomeActivity();
        }

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoginActivity();
            }
        });

        Button signUpButton = (Button) findViewById(R.id.buttonSignUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUpActivity();
            }
        });
    }

    private void startLoginActivity(){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void startHomeActivity(){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void startSignUpActivity(){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}

