package com.fyp.calligraphytutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AutoDrawWithoutAccountActivity extends AppCompatActivity {

    private Button clear;
    private Button color;
    private Button manual_draw;
    private AutoDrawWAView draw_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_auto_draw_waview);

        clear = findViewById(R.id.clear_button);
        color = findViewById(R.id.color_button);
        manual_draw = findViewById(R.id.manual_draw_button);
        draw_view = findViewById(R.id.autoDrawWAView);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean hello = draw_view.clear();
                Toast.makeText(getApplicationContext(), "Screen Cleared: " + hello, Toast.LENGTH_SHORT).show();
            }
        });

        manual_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AutoDrawWithoutAccountActivity.this, DrawWithoutAccountActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Manual-Draw Mode", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
