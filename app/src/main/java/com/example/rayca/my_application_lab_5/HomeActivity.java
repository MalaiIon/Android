package com.example.rayca.my_application_lab_5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.rayca.my_application_lab_5.model.Consultation;


public class HomeActivity extends BaseActivity {

    private EditText editTextName;
    private EditText editTextDisease;
    private EditText editTextWhereLocation;
    private EditText editTextDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        my change
//        setContentView(R.layout.activity_home);
        editTextName = findViewById(R.id.editTextName);
        editTextDisease = findViewById(R.id.editTextDisease);
        editTextWhereLocation = findViewById(R.id.editTextWhereLocation);
        editTextDescription = findViewById(R.id.editTextDescription);

        Toolbar myToolbarHome = findViewById(R.id.idToolbarHome);
//        myToolbarHome.setI
        setSupportActionBar(myToolbarHome);


        Button requestButton = findViewById(R.id.buttonRequest);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLoggedIn = App.checkAuth();
                //true
                if ( isLoggedIn ) {
                    startDoctorListActivity();
                }
            }
        });

       }

    @Override
    int getContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_home;
    }

    private void startDoctorListActivity(){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, DoctorListActivity.class);
        Consultation consultation = new Consultation(
                editTextName.getText().toString(),
                editTextDisease.getText().toString(),
                editTextWhereLocation.getText().toString(),
                editTextDescription.getText().toString()
        );
        intent.putExtra("consultation", consultation);
        startActivity(intent);
    }

    private void startWelcomeActivity(){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.logOut:
                App.logOut();
                startWelcomeActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
