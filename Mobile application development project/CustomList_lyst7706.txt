package com.example.hoteligo;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] hotel;
    private final Integer[] imageId;

    public CustomList(Activity context, String[] hotel, Integer[] imageId) {
        super(context, R.layout.custom_list, hotel);
        this.context = context;
        this.hotel = hotel;
        this.imageId = imageId;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list, null, true);
        TextView txtTitle = rowView.findViewById(R.id.txt);
        ImageView imageView = rowView.findViewById(R.id.img);

        txtTitle.setText(hotel[position]); //hotel[0]
        imageView.setImageResource(imageId[position]); //imageId[0]

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("key", hotel[position]);
                context.startActivity(intent);
            }
        });

        return rowView;

    }

}
