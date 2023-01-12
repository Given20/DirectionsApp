package com.example.herewego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class profile_page extends AppCompatActivity {

    ImageButton btnImagV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        btnImagV=findViewById(R.id.edtbackBtn);


        btnImagV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(profile_page.this, Settingpage.class);
                startActivity(intent);
            }
        });
    }


}