package com.fyp.calligraphytutor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;

public class RegisterActivity extends AppCompatActivity {

    private Button register;
    private EditText username;
    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText password;
    private EditText cpassword;
    private UserDB udb;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        udb = new UserDB(this);
        register = (Button) findViewById(R.id.register_button);
        username = (EditText) findViewById(R.id.reg_username);
        name = (EditText) findViewById(R.id.reg_name);
        email = (EditText) findViewById(R.id.reg_email);
        phone = (EditText) findViewById(R.id.reg_phone);
        password = (EditText) findViewById(R.id.reg_pass);
        cpassword = (EditText) findViewById(R.id.reg_cpass);
        
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strusername = username.getText().toString();
                String strname = name.getText().toString();
                String stremail = email.getText().toString();
                String strphone = phone.getText().toString();
                String strpass = password.getText().toString();
                String strcpass = cpassword.getText().toString();

                if (strusername.isEmpty() || strname.isEmpty() || stremail.isEmpty() || strphone.isEmpty() || strpass.isEmpty() || strcpass.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill complete form", Toast.LENGTH_SHORT).show();
                } else if (!strcpass.equals(strpass)) {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(stremail).matches())) {
                    Toast.makeText(RegisterActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                } else if (!(Patterns.PHONE.matcher(strphone).matches())) {
                    Toast.makeText(RegisterActivity.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                } else if (udb.checkemail(stremail)) {
                    Toast.makeText(RegisterActivity.this, "Email already registered", Toast.LENGTH_SHORT).show();
                } else if (udb.checkusername(strusername)) {
                    Toast.makeText(RegisterActivity.this, "Username not available", Toast.LENGTH_SHORT).show();
                } else {
                    boolean newuser = udb.insertUser(strusername, strname, stremail, strphone, strpass);
                    if (newuser) {
                        Toast.makeText(RegisterActivity.this, "Account successfully registered. Logging in...", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("username", strusername);
                        editor.commit();

                        Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    }
                }
                
            }
        });

    }
}
