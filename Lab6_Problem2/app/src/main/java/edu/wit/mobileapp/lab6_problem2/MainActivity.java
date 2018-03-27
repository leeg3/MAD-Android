package edu.wit.mobileapp.lab6_problem2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create image and place at /res/drawable
        Bitmap defaultImage;
        defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.default_image);

        //create testing data
        List<ListItem> list = new ArrayList<ListItem>();

        ListItem item1 = new ListItem();
        item1.image = defaultImage;
        item1.name = "David";
        item1.comment = "Boston is now snowing now";
        list.add(item1);

        ListItem item2 = new ListItem();
        item2.image = defaultImage;
        item2.name = "Cooper";
        item2.comment = "This design is so cool";
        list.add(item2);

        ListItem item3 = new ListItem();
        item3.image = defaultImage;
        item3.name = "Jones";
        item3.comment = "I like hacking. Do you like it?";
        list.add(item3);

        //create list adapter
        ListItemAdapter adapter;
        adapter = new ListItemAdapter(this, 0, list);

        //assign listitemadapter to a listview
        ListView listView = (ListView)findViewById(R.id.ListView1);
        listView.setAdapter(adapter);


    }
}
