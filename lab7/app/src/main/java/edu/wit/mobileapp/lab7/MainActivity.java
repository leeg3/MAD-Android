package edu.wit.mobileapp.lab7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create image and place at /res/drawable
        Bitmap defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.default_image);

        //init arraylist to hold the items to display
        List<GridItem> list = new ArrayList<GridItem>();

        //get the current date in the format of yyyy-MM-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());

        //init, add info to GridItem and add list for 12 items
        GridItem item1 = new GridItem();
        addItemProperties(item1, defaultImage, "Title-1", currentDate);
        list.add(item1);

        GridItem item2 = new GridItem();
        addItemProperties(item2, defaultImage, "Title-2", currentDate);
        list.add(item2);

        GridItem item3 = new GridItem();
        addItemProperties(item3, defaultImage, "Title-3", currentDate);
        list.add(item3);

        GridItem item4 = new GridItem();
        addItemProperties(item4, defaultImage, "Title-4", currentDate);
        list.add(item4);

        GridItem item5 = new GridItem();
        addItemProperties(item5, defaultImage, "Title-5", currentDate);
        list.add(item5);

        GridItem item6 = new GridItem();
        addItemProperties(item6, defaultImage, "Title-6", currentDate);
        list.add(item6);

        GridItem item7 = new GridItem();
        addItemProperties(item7, defaultImage, "Title-7", currentDate);
        list.add(item7);

        GridItem item8 = new GridItem();
        addItemProperties(item8, defaultImage, "Title-8", currentDate);
        list.add(item8);

        GridItem item9 = new GridItem();
        addItemProperties(item9, defaultImage, "Title-9", currentDate);
        list.add(item9);

        GridItem item10 = new GridItem();
        addItemProperties(item10, defaultImage, "Title-10", currentDate);
        list.add(item10);

        GridItem item11 = new GridItem();
        addItemProperties(item11, defaultImage, "Title-11", currentDate);
        list.add(item11);

        GridItem item12 = new GridItem();
        addItemProperties(item12, defaultImage, "Title-12", currentDate);
        list.add(item12);

        //init the GridItemAdapter adapter
        GridItemAdapter adapter = new GridItemAdapter(this, 0, list);

        //assign gridView to a GridView
        GridView gridView = (GridView)findViewById(R.id.GridView1);
        gridView.setAdapter(adapter);

    }

    //private function to easily add items to each gridItem instance.
    private void addItemProperties(GridItem gridItem, Bitmap image, String name, String date) {
        gridItem.image = image;
        gridItem.name = name;
        gridItem.description = date;
    }
}
