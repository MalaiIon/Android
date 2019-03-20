package com.example.rayca.my_application_lab_5;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class ScheduleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_schedule);

        Toolbar myToolbarDoctorList = findViewById(R.id.idToolbarSchedule);
        setSupportActionBar(myToolbarDoctorList);

    }
    @Override
    int getContentViewId() {
        return R.layout.activity_schedule;
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
