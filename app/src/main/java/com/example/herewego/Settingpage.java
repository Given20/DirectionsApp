package com.example.herewego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class Settingpage extends AppCompatActivity {
    Button editProfile,logout;
    BottomNavigationItemView setting,home,fav;
    ImageButton btnImagV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingpage);

        setting =findViewById(R.id.settings);
        home =findViewById(R.id.Home);
        fav =findViewById(R.id.favourite);
        btnImagV=findViewById(R.id.backImgButton);
        editProfile = findViewById(R.id.edt_profile_button);
        logout = findViewById(R.id.logout_btn);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settingpage.this,Settingpage.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settingpage.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settingpage.this, favourites_page.class);
                startActivity(intent);
            }
        });

        btnImagV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settingpage.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settingpage.this, profile_page.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settingpage.this, Login.class);
                startActivity(intent);
            }
        });
    }
}