package edu.wit.mobileapp.lab6_problem2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by leeg3 on 2/20/18.
 */

public class ListItemAdapter extends ArrayAdapter<ListItem> {

    private LayoutInflater mInflater;

    public ListItemAdapter(Context context, int rid, List<ListItem> list)
    {
        super(context, rid, list);
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        //retrieve data
        ListItem item = (ListItem) getItem(position);

        //Use layout file to generate view
        View view = mInflater.inflate(R.layout.list_item, null);

        //set image
        ImageView image;
        image = (ImageView) view.findViewById(R.id.image);
        image.setImageBitmap(item.image);

        //set username
        TextView name;
        name = (TextView)view.findViewById(R.id.name);
        name.setText(item.name);

        //set comment
        TextView comment;
        comment = (TextView)view.findViewById(R.id.comment);
        comment.setText(item.comment);

        return view;
    }
}