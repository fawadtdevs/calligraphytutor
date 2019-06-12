package com.fyp.calligraphytutor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button login_register;
    private Button login;
    private EditText username;
    private EditText password;
    private UserDB udb;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        udb = new UserDB(this);
        prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        login_register = (Button) findViewById(R.id.login_register);
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = (EditText) findViewById(R.id.login_username);
                password = (EditText) findViewById(R.id.login_password);
                String struser = username.getText().toString();
                String strpass = password.getText().toString();
                if (udb.validate(struser, strpass)) {
                    Toast.makeText(getApplicationContext(), "Welcome " + struser + "!", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("username", struser);
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect login details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
