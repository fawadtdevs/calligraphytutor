package com.fyp.calligraphytutor;

import android.widget.ImageView;

/**
 * Created by Fawad on 1/14/2019.
 */

public class TutorialModel {

    String title;
    String progress;
    ImageView image;

    public TutorialModel(String name, String type, String version_number, ImageView image) {
        this.title = title;
        this.progress = progress;
        this.image = image;

    }

    public TutorialModel(String title, String progress) {
        this.title = title;
        this.progress = progress;
    }

    public String getName() {
        return title;
    }

    public String getType() {
        return progress;
    }

    public ImageView getImage() {
        return image;
    }

}

