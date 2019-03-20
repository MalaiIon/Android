package com.example.rayca.my_application_lab_5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.rayca.my_application_lab_5.adapter.DoctorAdapter;
import com.example.rayca.my_application_lab_5.model.Consultation;
import com.example.rayca.my_application_lab_5.model.Doctor;
import com.example.rayca.my_application_lab_5.model.API.DoctorApiResponse;
import com.example.rayca.my_application_lab_5.model.API.DoctorListApiResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorListActivity extends BaseActivity {


    private DoctorAdapter doctorAdapter;
    private Consultation consultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        my change
//        setContentView(R.layout.activity_doctor_list);

        Toolbar myToolbarDoctorList = findViewById(R.id.idToolbarDoctorList);
        setSupportActionBar(myToolbarDoctorList);
//        arrow back
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        consultation = (Consultation) getIntent().getSerializableExtra("consultation");

//        ArrayList<Doctor> doctorList = new ArrayList<>();
//        doctorList.add(new Doctor("Joseph", "Bambuk", "ciocana", 4.9, R.drawable.doctor_list_1, "Lorem"));
//        doctorList.add(new Doctor("Max", "Bamb", "riscani", 4.8, R.drawable.doctor_list_2, "Lorem impsum"));
//        doctorList.add(new Doctor("Jim", "Rector", "buiucani", 4.7, R.drawable.doctor_list_3, "Lorem impsum dolor"));
//        doctorList.add(new Doctor("Richard", "Bzih", "botanica", 4.6, R.drawable.doctor_list_4, "Lorem impsum dolor sit"));
//        doctorList.add(new Doctor("Joseph", "Bambuk", "ciocana", 4.9, R.drawable.doctor_list_1, "Lorem"));
//        doctorList.add(new Doctor("Max", "Bamb", "riscani", 4.8, R.drawable.doctor_list_2, "Lorem impsum"));
//        doctorList.add(new Doctor("Jim", "Rector", "buiucani", 4.7, R.drawable.doctor_list_3, "Lorem impsum dolor"));
//        doctorList.add(new Doctor("Richard", "Bzih", "botanica", 4.6, R.drawable.doctor_list_4, "Lorem impsum dolor sit"));
//        doctorList.add(new Doctor("asd", "asd", "asd", 2.5, R.drawable.doctor_list_1, "asd"));

        this.doctorAdapter = new DoctorAdapter(this);
        ListView listView = findViewById(R.id.doctorListView);
        listView.setAdapter(doctorAdapter);
        fetchDoctorList(this.doctorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Doctor doctor = (Doctor) parent.getItemAtPosition(position);
                if (!App.checkAuth()) {
                    startWelcomeActivity();
                }

                startDoctorDetailsActivity(doctor);
//                startNotificationProfileActivity(doctor);
//                Doctor doctor_notification = (Doctor) parent.getItemAtPosition(position);
//                startDoctorDetailsActivity(doctor_notification);
//                startNotificationProfileActivity(doctor_notification);
            }
        });


    }

    private void fetchDoctorList(DoctorAdapter doctorAdapter){
        String token = App.getAuthToken();

        App.getApi().getDoctorList(token).enqueue(new Callback<List<DoctorApiResponse>>() {
            @Override
            public void onResponse(Call<List<DoctorApiResponse>> call, Response<List<DoctorApiResponse>> response) {
                Log.d("myTagResponse", response.toString());
                List<DoctorApiResponse> responseBody = response.body();
                if (responseBody != null) {
                    ArrayList<Doctor> doctorList = new ArrayList<>();
//                    for (int i = 0; i < responseBody.getDoctorList().size(); i++) {
//                        DoctorApiResponse doctor = responseBody.getDoctorList().get(i);
//                        // ....
//                    }
                    for (DoctorApiResponse doctor : responseBody){
//                        byte[] decodedString = Base64.decode(doctor.getPhoto(), Base64.DEFAULT);
//                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                        doctorList.add(new Doctor(
                                doctor.getDocId(),
                                doctor.getFullName(),
                                doctor.getSpecs(),
                                doctor.getAddress(),
                                doctor.getStars(),
//                                image photo to base-64 convert to bitmap
                                doctor.getPhoto(),
//                                decodedByte,
//                                doctor.getPhoto(),
                                doctor.getAbout()
                        ));
//                        byte[] decodedString = Base64.decode(doctor.getPhoto(), Base64.DEFAULT);
//                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                    }

                    doctorAdapter.setDoctorslist(doctorList);
                }
            }
            @Override
            public void onFailure(Call<List<DoctorApiResponse>> call, Throwable t) {
                Log.d("myTagFailure", t.toString());
            }
        });
    }

    private void startDoctorDetailsActivity(Doctor doctor){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, DoctorDetailsActivity.class);
        intent.putExtra("doctorObject", doctor);
        intent.putExtra("consultation", consultation);
        startActivity(intent);
    }

    private void startWelcomeActivity(){
        //Intent - намерение перейти на другое activity
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

//    private void startNotificationProfileActivity(Doctor doctor){
//        //Intent - намерение перейти на другое activity
//        Intent intent = new Intent(this, NotificationProfileActivity.class);
//        intent.putExtra("doctorObject", doctor);
//        startActivity(intent);
//    }

    @Override
    int getContentViewId() {
        return R.layout.activity_doctor_list;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_home;
    }

    //    bar and ... points
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doctor_list_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}


