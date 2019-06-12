package com.fyp.calligraphytutor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Fawad on 3/24/2019.
 */

public class TutorialsListView extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] tutorial;
    private final String[] progress;
    private final Integer[] imgid;
    private final Boolean[] done;

    public TutorialsListView(Activity context, String[] tutorial, String[] progress, Integer[] imgid, Boolean[] done) {
        super(context, R.layout.tutorial_list_item, tutorial);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.tutorial=tutorial;
        this.progress=progress;
        this.imgid=imgid;
        this.done=done;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.tutorial_list_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.titletext);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.listimage);
        TextView progressText = (TextView) rowView.findViewById(R.id.progresstext);

        titleText.setText(tutorial[position]);
        imageView.setImageResource(imgid[position]);
        progressText.setText(progress[position]);

        //if (done[position]) {
            //titleText.setText(tutorial[position]+" (done)");
        //}

        return rowView;

    }

}
