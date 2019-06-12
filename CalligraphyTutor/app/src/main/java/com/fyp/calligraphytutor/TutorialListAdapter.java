package com.fyp.calligraphytutor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fyp.calligraphytutor.R;

import java.util.ArrayList;

/**
 * Created by Fawad on 1/14/2019.
 */

public class TutorialListAdapter extends ArrayAdapter<TutorialModel> implements View.OnClickListener{

    private ArrayList<TutorialModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView title;
        TextView progress;
        ImageView image;
    }

    public TutorialListAdapter(ArrayList<TutorialModel> data, Context context) {
        super(context, R.layout.tutorial_list_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        TutorialModel dataModel=(TutorialModel)object;

        /*switch (v.getId())
        {
            case R.id.item_info:
                //Toast.makeText(this.getContext(), "." +dataModel.getFeature(),
                //               Toast.LENGTH_SHORT).show();
                //Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                //        .setAction("No action", null).show();
                break;
        }*/
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TutorialModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tutorial_list_item, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.titletext);
            viewHolder.progress = (TextView) convertView.findViewById(R.id.progresstext);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.listimage);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.title.setText(dataModel.getName());
        viewHolder.progress.setText(dataModel.getType());
        //viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
