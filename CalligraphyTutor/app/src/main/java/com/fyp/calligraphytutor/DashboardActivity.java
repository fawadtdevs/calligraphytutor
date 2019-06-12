package com.fyp.calligraphytutor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DashboardActivity extends AppCompatActivity {

    ArrayList<TutorialModel> tutorials;
    ListView listView;
    private Button logout;
    private TextView usernametext;
    private static TutorialListAdapter adapter;
    private UserDB udb;
    private SharedPreferences prefs;

    String[] tutorial = {
            "Alif", "Alif-mad-aa", "Bay", "Pay", "Tay", "TTay", "Say", "Jeem", "Chay", "Hay", "Khay", "Daal", "DDaal", "Zaal", "Ray", "RRay", "Zay", "Say", "Seen", "Sheen", "Suaad", "Zuaad", "Toayein", "Zoayein", "Aein", "Ghaein", "Fay", "Qaaf", "Kaaf", "Gaaf", "Laam", "Meem", "Noon", "Waao", "Hay", "Hamza", "Choti Yaa", "Barri Yaa", "Bay Alif", "Bay Bay", "Bay Jeem", "Bay Daal", "Bay Ray", "Bay Seen", "Bay Suad", "Bay Toayein", "Bay Aein", "Bay Fay", "Bay Qaaf", "Bay Kaaf", "Bay Laam", "Bay Meem", "Bay Noon", "Bay Waao", "Bay Hay", "Bay Choti Yaa", "Bay Bari Yaa"
    };

    String[] progress = new String[57];

    Integer[] imgid = {
            R.mipmap.c0,R.mipmap.c1,R.mipmap.c2,R.mipmap.c3,R.mipmap.c4,R.mipmap.c5,R.mipmap.c6,R.mipmap.c7,R.mipmap.c8,R.mipmap.c9,R.mipmap.c10,R.mipmap.c11,R.mipmap.c12,R.mipmap.c13,R.mipmap.c14,R.mipmap.c15,R.mipmap.c16,R.mipmap.c17,R.mipmap.c18,R.mipmap.c19,R.mipmap.c20,R.mipmap.c21,R.mipmap.c22,R.mipmap.c23,R.mipmap.c24,R.mipmap.c25,R.mipmap.c26,R.mipmap.c27,R.mipmap.c28,R.mipmap.c29,R.mipmap.c30,R.mipmap.c31,R.mipmap.c32,R.mipmap.c33,R.mipmap.c34,R.mipmap.c35,R.mipmap.c36,R.mipmap.c37,R.mipmap.c38,R.mipmap.c39,R.mipmap.c40,R.mipmap.c41,R.mipmap.c42,R.mipmap.c43,R.mipmap.c44,R.mipmap.c45,R.mipmap.c46,R.mipmap.c47,R.mipmap.c48,R.mipmap.c49,R.mipmap.c50,R.mipmap.c51,R.mipmap.c52,R.mipmap.c53,R.mipmap.c54,R.mipmap.c55,R.mipmap.c56
    };

    Boolean[] done={
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String uu = prefs.getString("username", "");
        usernametext = (TextView) findViewById(R.id.usernametext);
        usernametext.setText(uu);

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        for (int i = 0; i < progress.length; i++) {
            progress[i] = "Learn to write "+tutorial[i];
        }

        final TutorialsListView adapter = new TutorialsListView(this, tutorial, progress, imgid, done);
        listView = (ListView) findViewById(R.id.tutorials_list);

        //list = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);


        tutorials = new ArrayList<>();

        tutorials.add(new TutorialModel("Alif", "Learn to write Alif"));
        tutorials.add(new TutorialModel("Daal", "Learn to write Bay"));
        tutorials.add(new TutorialModel("Choti Yaa", "Learn to write Jeem"));


        //adapter= new TutorialListAdapter(tutorials,getApplicationContext());

        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //TutorialModel dataModel = tutorials.get(position);
                //Toast.makeText(getApplicationContext(), dataModel.getName()+"\n"+dataModel.getType()+" Learn to Draw", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, DrawWithoutAccountActivity.class);
                intent.putExtra("value", position);
                startActivity(intent);
            }
        });

    }
}
