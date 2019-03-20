package com.example.rayca.my_application_lab_5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rayca.my_application_lab_5.model.Consultation;
import com.example.rayca.my_application_lab_5.model.Doctor;


public class NotificationProfileActivity extends BaseActivity{

    private Doctor doctor;
    private Consultation consultation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //my change
//        setContentView(R.layout.activity_notification_profile);

        Intent intent = getIntent();
        doctor = (Doctor) intent.getSerializableExtra("doctorObject");
        consultation = (Consultation) intent.getSerializableExtra("consultation");

        TextView patientName = findViewById(R.id.idPatientName);
        patientName.setText(consultation.getName());
        TextView patientDisease = findViewById(R.id.idDescribeDiseaseProfile);
        patientDisease.setText(consultation.getDisease());
        TextView patientAddress = findViewById(R.id.idLocationAddress);
        patientAddress.setText(consultation.getLocation());
        TextView patientDescription = findViewById(R.id.idDescriptionNotificationProfile);
        patientDescription.setText(consultation.getDescription());
//// View in the activity, но берем инофрмацию из DoctorListActivity
        ImageView doctorImageView = findViewById(R.id.doctorImageProfile);
//        doctorImageView.setImageBitmap(doctor.getPhoto());
        byte[] decodedString = Base64.decode(doctor.getPhoto(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        doctorImageView.setImageBitmap(decodedByte);

        TextView doctorNameTextView = findViewById(R.id.doctorNameProfile);
        doctorNameTextView.setText(doctor.getName());

        TextView doctorSpecialityTextView = findViewById(R.id.doctorSpecialityProfile);
        doctorSpecialityTextView.setText(doctor.getSpeciality());

        TextView doctorRatingTextView = findViewById(R.id.doctorRatingProfile);
        doctorRatingTextView.setText(String.valueOf(doctor.getRating()));
//        end change

        Toolbar myToolbarDoctorList = findViewById(R.id.idToolbarNotification);
        setSupportActionBar(myToolbarDoctorList);


//        arrow back
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


    }


    @Override
    int getContentViewId() {
        return R.layout.activity_notification_profile;
    }

    @Override
    int getNavigationMenuItemId() {
        return 0;
    }
//    back to Login, but back to Home is true
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notification_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
