package com.example.herewego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Database_Helper DB;
    EditText EmailAdd,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView registerHereBtn= findViewById(R.id.registerHereBtn);
        final Button login=findViewById(R.id.loginBtn);

        EmailAdd = findViewById(R.id.EmailAd);
        password= findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(new Intent(Login.this,MapsActivity.class));
                startActivity(intent);



               /* String user= EmailAdd.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();


                Boolean checkuserpass= DB.checkUserPassword(user,pass);
                if (checkuserpass==true ){
                    Toast.makeText(Login.this, "Sign in successful", Toast.LENGTH_SHORT).show();


                    if(user.isEmpty()|| user.contains("@")) {
                    }else{
                        showError(EmailAdd,"Invalid Email");
                    }
                }else{
                    Toast.makeText(Login.this, "Wrong Password", Toast.LENGTH_SHORT).show();

                }
*/


            }
        });

        registerHereBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            finish();
            }
        });

    }
    private void showError(EditText input, String your_username_is_not_valid) {

        input.setError(your_username_is_not_valid);
        input.requestFocus();
    }

    public void openScreen(){
        Intent intent= new Intent(new Intent(Login.this,MapsActivity.class));
        startActivity(intent);
    }
}