package com.fyp.calligraphytutor;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.VideoView;

public class DrawWithoutAccountActivity extends AppCompatActivity {

    private Button clear;
    private Button color;
    private Switch auto_draw;
    private DrawWAView draw_view;
    private EditText showstats;
    private VideoView demo;
    public int alifvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alifvalue = this.getIntent().getIntExtra("value",0);
        setContentView(R.layout.sample_draw_waview);
        demo = findViewById(R.id.sample_video);
        /*Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.testalif);
        demo.setVideoURI(uri);
        demo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                demo.start();
            }
        });
        demo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                demo.setEnabled(false);
                demo.setVisibility(View.INVISIBLE);
            }
        });*/
        clear = findViewById(R.id.clear_button);
        color = findViewById(R.id.color_button);
        auto_draw = findViewById(R.id.auto_draw_button);
        draw_view = findViewById(R.id.drawWAView);
        showstats = findViewById(R.id.showstats);

        draw_view.setvalue(alifvalue);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean hello = draw_view.clear();
                if (hello) {
                    Toast.makeText(getApplicationContext(), "Screen Cleared", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error! Screen Not Cleared", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*auto_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawWithoutAccountActivity.this, AutoDrawWithoutAccountActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Auto-Draw Mode", Toast.LENGTH_SHORT).show();
            }
        });*/
        auto_draw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    draw_view.autodrawvalue = true;
                    Toast.makeText(getApplicationContext(), "Single Touch Auto Draw Mode Enabled", Toast.LENGTH_SHORT).show();
                } else {
                    draw_view.autodrawvalue = false;
                    Toast.makeText(getApplicationContext(), "Normal Mode Enabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recog = draw_view.recognize(false);
                showstats.setText(recog);
                recog = draw_view.recognize(true);
                showstats.setText(recog);
            }
        });

    }

    public boolean setstat(String stat) {
        showstats.setText(stat);
        return true;
    }
}
