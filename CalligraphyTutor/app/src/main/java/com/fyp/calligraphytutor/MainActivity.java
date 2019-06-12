package com.fyp.calligraphytutor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button home_login;
    private Button home_register;
    private Button home_without;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String uu = prefs.getString("username", "");
        if (uu != "") {
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(intent);
        }
        home_login = (Button) findViewById(R.id.home_login);
        home_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        home_register = (Button) findViewById(R.id.home_register);
        home_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        home_without = (Button) findViewById(R.id.home_without);
        home_without.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawWithoutAccountActivity.class);
                startActivity(intent);
            }
        });

    }
}