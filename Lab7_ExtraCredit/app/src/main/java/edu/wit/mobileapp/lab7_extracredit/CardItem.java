package edu.wit.mobileapp.lab7_extracredit;

import android.graphics.Bitmap;

/**
 * Created by leeg3 on 2/27/18.
 */

public class CardItem {
    public Bitmap image;
    public String name;
    public String description;

    public CardItem(Bitmap image, String str1, String str2) {
        this.image = image;
        name = str1;
        description = str2;
    }

    public String getInfo() {
        return name;
    }

}
