package com.example.rayca.my_application_lab_5.Example;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.rayca.my_application_lab_5.DoctorListActivity;
import com.example.rayca.my_application_lab_5.HomeActivity;
import com.example.rayca.my_application_lab_5.R;

public abstract class BaseFragmentActivity extends FragmentActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(getContentViewId());

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        updateNavigationBarState();
//    }

    // Remove inter-activity transition to avoid screen tossing on tapping bottom navigation items
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        navigationView.postDelayed(() -> {
            int itemId = item.getItemId();

            switch (itemId) {
                case R.id.navigation_home: startActivity(new Intent(this, HomeActivity.class)); break;
                case R.id.navigation_notifications: startActivity(new Intent(this, DoctorListActivity.class));break;
                case R.id.navigation_plus: startActivity(new Intent(this, DoctorListActivity.class)); break;
                case R.id.navigation_schedule: startActivity(new Intent(this, HomeActivity.class)); break;
                case R.id.navigation_profile: startActivity(new Intent(this, HomeActivity.class)); break;
                default: break;
            }
            finish();
        }, 300);
        return true;
    }

//    private void updateNavigationBarState(){
//        int actionId = getNavigationMenuItemId();
//        selectBottomNavigationBarItem(actionId);
//    }
//
//    void selectBottomNavigationBarItem(int itemId) {
//        MenuItem item = navigationView.getMenu().findItem(itemId);
//        item.setChecked(true);
//    }
//
//    abstract int getContentViewId();
//
//    abstract int getNavigationMenuItemId();

}