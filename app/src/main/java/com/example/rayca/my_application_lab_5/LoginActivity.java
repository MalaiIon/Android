package com.example.rayca.my_application_lab_5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rayca.my_application_lab_5.model.API.LoginApiRequest;
import com.example.rayca.my_application_lab_5.model.API.LoginUserApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Log.d("ABRAKADABRA", "OCTAVIAN WITH LOVE");
//
//        Log.d("TokenMyLoveOctavianTral", getSharedPreferences("MyPreferences", MODE_PRIVATE).getString("token", "RANDOM"));

        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginApiRequest loginApiRequest = new LoginApiRequest(
                        editTextEmail.getText().toString(),
                        editTextPassword.getText().toString()
                );

//                App.createTelemedicineAPI();
//                if(App.getApi() == null)
//                    return;

                App.getApi().loginUser(loginApiRequest).enqueue(new Callback<LoginUserApiResponse>() {
                    @Override
                    public void onResponse(Call<LoginUserApiResponse> call, Response<LoginUserApiResponse> response) {
                        LoginUserApiResponse apiResponse = response.body();
//                        Log.d("GOT HERE SKA", "gote here");

                        if (apiResponse == null) return;

//                        Log.d("TEST_TOKEN", apiResponse.toString());

                        if(apiResponse.getStatus().equals("SUCCESS")) {
                            App.logIn(apiResponse.getMessage());
                            startHomeActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginUserApiResponse> call, Throwable t) {
                        Log.d("ERROR", t.toString());
                    }
                });
            }
        });

        Button signUpButton = findViewById(R.id.buttonSignUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUpActivity();
            }
        });
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
