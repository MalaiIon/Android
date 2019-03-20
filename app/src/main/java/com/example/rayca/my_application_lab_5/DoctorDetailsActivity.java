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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rayca.my_application_lab_5.model.API.AddConsultationApiRequest;
import com.example.rayca.my_application_lab_5.model.API.AddConsultationApiResponse;
import com.example.rayca.my_application_lab_5.model.Consultation;
import com.example.rayca.my_application_lab_5.model.Doctor;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//implements OnMapReadyCallback
public class DoctorDetailsActivity extends BaseActivity  {

    private GoogleMap myMap;
    private Doctor doctor;
    private Consultation consultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        my changes
//        setContentView(R.layout.activity_doctor_details);

        Intent intent = getIntent();
        doctor = (Doctor) intent.getSerializableExtra("doctorObject");
        consultation = (Consultation) intent.getSerializableExtra("consultation");

        // View in the activity, но берем инофрмацию из DoctorListActivity
        ImageView doctorImageView = findViewById(R.id.doctorImage);
        byte[] decodedString = Base64.decode(doctor.getPhoto(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        doctorImageView.setImageBitmap(decodedByte);

        TextView doctorNameTextView = findViewById(R.id.doctorName);
        doctorNameTextView.setText(doctor.getName());

        TextView doctorSpecialityTextView = findViewById(R.id.doctorSpeciality);
        doctorSpecialityTextView.setText(doctor.getSpeciality());

        TextView doctorRatingTextView = findViewById(R.id.doctorRating);
        doctorRatingTextView.setText(String.valueOf(doctor.getRating()));

        Toolbar myToolbarDoctorDetails = findViewById(R.id.idToolbarDoctorDetails);
        setSupportActionBar(myToolbarDoctorDetails);

        TextView shortDescriptionTextView = findViewById(R.id.idShortDescription);
        shortDescriptionTextView.setText(doctor.getShortDescription());

        TextView doctorAddressTextView = findViewById(R.id.idDoctorAddress);
        doctorAddressTextView.setText(doctor.getAddress());

//        arrow back
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Button requestButton = findViewById(R.id.buttonRequestDoctorDetails);


        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!App.checkAuth()) {
                    startWelcomeActivity();
                }
                AddConsultationApiRequest addConsultationApiRequest = new AddConsultationApiRequest(
                        consultation.getName(),
                        consultation.getDisease(),
                        consultation.getLocation(),
                        consultation.getDescription(),
                        doctor.getDocId()
                );
                App.getApi().addConsultation(App.getAuthToken(), addConsultationApiRequest).enqueue(new Callback<AddConsultationApiResponse>() {
                    @Override
                    public void onResponse(Call<AddConsultationApiResponse> call, Response<AddConsultationApiResponse> response) {
                        startNotificationActivity(doctor);
                    }

                    @Override
                    public void onFailure(Call<AddConsultationApiResponse> call, Throwable t) {
                    }
                });

            }
        });
//Map from
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }
    //    bar and ... points

    private void startNotificationActivity(Doctor doctor){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, NotificationProfileActivity.class);
        intent.putExtra("doctorObject", doctor);
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
        getMenuInflater().inflate(R.menu.doctor_details_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    int getContentViewId() {
        return R.layout.activity_doctor_details;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_home;
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        myMap = googleMap;
//        LatLng latLng = new LatLng(42, 43);
//
//        MarkerOptions marker = new MarkerOptions().position(latLng);
//        myMap.addMarker(marker);
//    }
}