package com.example.rayca.my_application_lab_5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rayca.my_application_lab_5.model.API.ProfileApiResponse;
import com.example.rayca.my_application_lab_5.model.Doctor;
import com.example.rayca.my_application_lab_5.model.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileActivity extends BaseActivity {

    private ProfileApiResponse profileUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);

//        Intent intentProfile = getIntent();
//        profileUser = (Profile) intentProfile.getSerializableExtra("profileObject");

        TextView userName = findViewById(R.id.idNameProfile);
//        userName.setText(profileUser.getFullName());

        TextView userBirthday = findViewById(R.id.idProfileBirthday);
//        userBirthday.setText(profileUser.getBirthday());

        TextView userEmail = findViewById(R.id.idEmailProfile);
//        userEmail.setText(profileUser.getEmail());

        TextView userPhone = findViewById(R.id.idProfilePhone);
//        userPhone.setText(profileUser.getPhone());

        TextView userAddress = findViewById(R.id.idProfileAddress);
//        userAddress.setText(profileUser.getAddress());

        TextView userNickname = findViewById(R.id.idProfileUserName);
//        userNickname.setText(profileUser.getUsername());
//// Photo
        ImageView userPhoto = findViewById(R.id.idProfilePhoto);



//        userPhoto.setText(profileUser.getBase64Photo());
//// Status
//        TextView userStatus = findViewById(R.id.);
//        userStatus.setText(profileUser.getStatus());


        Toolbar myToolbarDoctorList = findViewById(R.id.idToolbarProfile);
        setSupportActionBar(myToolbarDoctorList);

        String token = App.getAuthToken();
        App.getApi().getProfile(token).enqueue(new Callback<ProfileApiResponse>(){

            @Override
            public void onResponse(Call < ProfileApiResponse > call, Response< ProfileApiResponse > response) {
                Log.d("myTagResponse", response.toString());
                ProfileApiResponse responseBody = response.body();
                if (responseBody != null) {
                            userName.setText(responseBody.getFullName());
                            userBirthday.setText(responseBody.getBirthday());
                            userEmail.setText(responseBody.getEmail());
                            userPhone.setText(responseBody.getPhone());
                            userAddress.setText(responseBody.getAddress());
                            userNickname.setText(responseBody.getUsername());
                    byte[] decodedString = Base64.decode(responseBody.getBase64Photo(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    userPhoto.setImageBitmap(decodedByte);

//                            userStatus.setText(responseBody.getStatus());
                }
            }

            @Override
            public void onFailure (Call < ProfileApiResponse > call, Throwable t){
                Log.d("myTagFailure", t.toString());
            }
        });
}

    @Override
    int getContentViewId() {
        return R.layout.activity_profile;
    }

    @Override
    int getNavigationMenuItemId() {
        return 0;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doctor_details_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
