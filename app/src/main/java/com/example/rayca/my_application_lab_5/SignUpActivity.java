package com.example.rayca.my_application_lab_5;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rayca.my_application_lab_5.model.API.SignUpApiRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar myToolbarSingUp = findViewById(R.id.idToolbarSign_up);
        setSupportActionBar(myToolbarSingUp);

        EditText editTextFullName = findViewById(R.id.editTextFullName);
        EditText editTextBirthday = findViewById(R.id.editTextBirthday);
        EditText editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        EditText editTextAddress = findViewById(R.id.editTextLocation);

        Button nextButton = findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpApiRequest user = new SignUpApiRequest(
                        editTextFullName.getText().toString(),
                        editTextBirthday.getText().toString(),
                        editTextEmailAddress.getText().toString(),
                        editTextPhoneNumber.getText().toString(),
                        editTextAddress.getText().toString(),
                        editTextEmailAddress.getText().toString(),
                        editTextPassword.getText().toString(),
                        "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"
                );
                App.getApi().registerUser(user).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if ( response.body() == null)
                            return;
                        if (response.body().equals("SUCCESS")) {
                            startHomeActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("Error", "registration error" + t.toString());
                    }
                });
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageButtonAddPhoto);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this, "Galery", Toast.LENGTH_SHORT).show();
            }
        });

// <- Button back
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    //Button next
    private void startHomeActivity(){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
//       <- Button back
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sing_up_bar_back, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
