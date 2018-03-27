package edu.wit.mobileapp.lab7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class GridItemAdapter extends ArrayAdapter<GridItem> {

    private LayoutInflater mInflater;

    public GridItemAdapter(Context context, int rid, List<GridItem> list) {
        super(context, rid, list);
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View contentView, ViewGroup parent) {

        //retrieve data
        GridItem item = (GridItem)getItem(position);

        //use layout to generate view
        View view = mInflater.inflate(R.layout.grid_item_adapter, null);

        //set image
        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageBitmap(item.image);

        //set username
        TextView name = (TextView)view.findViewById(R.id.name);
        name.setText(item.name);

        //set comment
        TextView comment = (TextView)view.findViewById(R.id.description);
        comment.setText(item.description);

        return view;
    }
}
