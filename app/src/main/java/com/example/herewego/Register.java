package com.example.herewego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText Uname,email,password,ConfirmPass,mobil;

    Database_Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Uname= findViewById(R.id.username);
        mobil=findViewById(R.id.Mobile);
        email= findViewById(R.id.EmailAd);
        password=findViewById(R.id.password);
        ConfirmPass=findViewById(R.id.Confirmpass);


        final TextView LoginHerebtn = findViewById(R.id.loginHereBtn);
        final Button registerBtn= findViewById(R.id.registerBtn);
        DB = new Database_Helper(this);



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = Uname.getText().toString();
                String mobile=mobil.getText().toString();
                String emails = email.getText().toString();
                String pass = password.getText().toString();
                String cpass = ConfirmPass.getText().toString();


                if ( user.isEmpty() || user.length()<5)
                    showError(Uname,"The length of the name must be more than 5 characters");
                if(emails.isEmpty()|| !emails.contains("@gmail.com"))
                    showError(email,"Email must contain @gmail.com");


                if (user.equals("") || emails.equals("") || pass.equals("") || cpass.equals(""))

                    Toast.makeText(Register.this, "Please enter all fields", Toast.LENGTH_LONG).show();
                else {
                    if (pass.equals(cpass)) {

                        Boolean checkuser = DB.checkUserEmail(emails);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(emails, pass);

                            if (insert == true) {
                                Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(new Intent(Register.this,Login.class));
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this, "Registered failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            showError(email,"User Already exists! please sign in");
                        }
                    } else {
                        showError(ConfirmPass,"Password not matching");
                        //Toast.makeText(Register_activity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        LoginHerebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Login.class));
            finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
      startActivity(new Intent(Register.this,Login.class));
    finish();
    }

    private void showError(EditText input, String your_username_is_not_valid) {

        input.setError(your_username_is_not_valid);
        input.requestFocus();
    }
}