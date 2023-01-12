package com.example.herewego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class favourites_page extends AppCompatActivity {
    BottomNavigationItemView setting,home,fav;
    ImageButton favImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites_page);


        setting =findViewById(R.id.settings);
        home =findViewById(R.id.Home);
        fav =findViewById(R.id.favourite);
        favImg =findViewById(R.id.favImgBtn);


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(favourites_page.this,Settingpage.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(favourites_page.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(favourites_page.this, favourites_page.class);
                startActivity(intent);
            }
        });

        favImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(favourites_page.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}