package com.example.rayca.my_application_lab_5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
//        System.err.println("IN ON CREATE ");
        Log.d("myTag", "In on create");
        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        }

    //    my changes
    private void updateNavigationBarState(){
        int actionId = getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    void selectBottomNavigationBarItem(int itemId){
        Menu menu = navigationView.getMenu();
        for(int i = 0, size = menu.size(); i < size; i++){
            MenuItem item = menu.getItem(i);
            boolean shouldBeChecked = item.getItemId() == itemId;
            if(shouldBeChecked){
                item.setChecked(true);
                break;
            }
        }
    }
    //end

//was commented
    @Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
    }

    // Remove inter-activity transition to avoid screen tossing on tapping bottom navigation items
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        navigationView.postDelayed(() -> {
            int itemId = item.getItemId();
            item.setEnabled(true);
            Log.d("myTag", "This is my message");
            switch (itemId) {
                case R.id.navigation_home: startActivity(new Intent(this, HomeActivity.class));
                break;
                case R.id.navigation_notifications: startActivity(new Intent(this, HomeActivity.class));
                    Toast.makeText(this, "Fill up all the fields!", Toast.LENGTH_SHORT).show();
                break;
                case R.id.navigation_plus: startActivity(new Intent(this, HomeActivity.class)); break;
                case R.id.navigation_schedule: startActivity(new Intent(this, ScheduleActivity.class)); break;
                case R.id.navigation_profile: startActivity(new Intent(this, ProfileActivity.class)); break;
                default: break;
            }
            finish();
        }, 300);
        return true;
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

// no comment
//    private void updateNavigationBarState(){
//        int actionId = getNavigationMenuItemId();
//        selectBottomNavigationBarItem(actionId);
//    }
// no comment
//    void selectBottomNavigationBarItem(int itemId) {
//        MenuItem item = navigationView.getMenu().findItem(itemId);
//        item.setChecked(true);
//    }

    abstract int getContentViewId();

    abstract int getNavigationMenuItemId();

}