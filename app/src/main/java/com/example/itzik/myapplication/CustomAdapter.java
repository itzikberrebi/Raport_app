package com.example.itzik.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter{
    public CustomAdapter(Context context, String[] posts) {
        super(context,R.layout.custom_row, posts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        String post_title = (String) getItem(position);
        TextView textview = (TextView) customView.findViewById(R.id.post_title);
        ImageView imageView = (ImageView) customView.findViewById(R.id.post_image);

        textview.setText(post_title);
        imageView.setImageResource(R.drawable.complaint);

        return customView;
    }
}
