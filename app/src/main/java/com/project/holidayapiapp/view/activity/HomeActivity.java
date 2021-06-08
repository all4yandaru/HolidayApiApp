package com.project.holidayapiapp.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.holidayapiapp.R;
import com.project.holidayapiapp.view.fragment.DatabaseFragment;
import com.project.holidayapiapp.view.fragment.HolidayApiFragment;
import com.project.holidayapiapp.view.fragment.ProfileFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.home_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HolidayApiFragment());
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_bottomnav_api:
                loadFragment(new HolidayApiFragment());
                break;

            case R.id.menu_bottomnav_database:
                loadFragment(new DatabaseFragment());
                break;

            case R.id.menu_bottomnav_profile:
                loadFragment(new ProfileFragment());
                break;
        }
        return false;
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_fragment_container, selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}