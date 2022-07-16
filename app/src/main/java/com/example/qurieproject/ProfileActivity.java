package com.example.qurieproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        ReviewFragment reviewFragment = new ReviewFragment();
        RecieveFragment recieveFragment = new RecieveFragment();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        return true;

                    case R.id.qrcode:
                        startActivity(new Intent(getApplicationContext(), QRActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.transfer:
                        startActivity(new Intent(getApplicationContext(), TransferActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return  false;
            }
        });

        BottomNavigationView bottomNavigationView1 = findViewById(R.id.bottom_navtop);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, reviewFragment).commit();

        bottomNavigationView1.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.reviewFrag:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, reviewFragment).commit();
                        return true;
                    case R.id.recieveFrag:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, recieveFragment).commit();
                        return true;
                }

                return false;
            }
        });



    }
}