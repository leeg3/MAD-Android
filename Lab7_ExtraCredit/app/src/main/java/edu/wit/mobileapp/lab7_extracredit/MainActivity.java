package edu.wit.mobileapp.lab7_extracredit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        /**
        //Create image and place at /res/drawable
        Bitmap defaultImage;
        defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.doge);

        //init arraylist to hold the items to display
        List<CardItem> list = new ArrayList<CardItem>();

        //get the current date in the format of yyyy-MM-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());

        //init, add info to GridItem and add list for 12 items
        CardItem item1 = new CardItem(defaultImage, "Title-1", currentDate);
        list.add(item1);

        //init the GridItemAdapter adapter
        //CardItemAdapter adapter = new CardItemAdapter(this, 0, list);

        //set cardView to the XML element cardview**/
        //mAdapter = new CardItemAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

    }

    //private function to easily add items to each gridItem instance.
    private void addItemProperties(CardItem cardItem, Bitmap image, String name, String date) {
        cardItem.image = image;
        cardItem.name = name;
        cardItem.description = date;
    }

    private ArrayList<CardItem> getDataSet() {
        ArrayList results = new ArrayList<CardItem>();
        Bitmap defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.doge);
        //get the current date in the format of yyyy-MM-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());

        for (int index = 0; index < 20; index++)
        {
            CardItem obj = new CardItem(defaultImage, "Title-" + index, currentDate);
            results.add(obj);
        }
        return results;
    }
}
