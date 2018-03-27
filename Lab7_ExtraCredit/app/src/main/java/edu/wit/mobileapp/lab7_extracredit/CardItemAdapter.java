package edu.wit.mobileapp.lab7_extracredit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class CardItemAdapter extends ArrayAdapter<CardItem> {

    private ArrayList<CardItem> mDataset;
    private LayoutInflater mInflater;

    public CardItemAdapter(Context context, int rid, List<CardItem> list) {
        super(context,rid, list);
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

   /** public CardItemAdapter(ArrayList<CardItem> myDataset) {
        this.mDataset = myDataset;
    }**.

    public View getView(int position, View contentView, ViewGroup parent) {

        //retrieve data
        CardItem item = (CardItem) getItem(position);

        //use layout to generate view
        View view = mInflater.inflate(R.layout.card_item_adapter, null);

        //set image
        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageBitmap(item.image);

        //set username
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(item.name);

        //set comment
        TextView comment = (TextView) view.findViewById(R.id.description);
        comment.setText(item.description);

        return view;
    }

    /**
    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView defaultImage;
        TextView label;
        TextView dateTime;

        public DataObjectHolder(View itemView) {
            super(itemView);

            //defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.doge);
            defaultImage = (ImageView) (ImageView) imageView.findViewById(R.id.image);
            label = (TextView) itemView.findViewById(R.id.name);
            dateTime = (TextView) itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public CardItemAdapter(ArrayList<CardItem> myDataset) {
        this.mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_adapter, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getInfo());
        holder.dateTime.setText(mDataset.get(position).getInfo());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }**/
}