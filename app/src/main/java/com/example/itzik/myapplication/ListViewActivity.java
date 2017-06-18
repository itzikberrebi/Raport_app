package com.example.itzik.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {

    public static final String TAG = "RAport";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_view);

            String[] posts = {"post1", "post2", "post3"};

//            ListAdapter listview_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, posts);
            ListAdapter listview_adapter = new CustomAdapter(this, posts);

            ListView listview = (ListView) findViewById(R.id.listview);
            listview.setAdapter(listview_adapter);

            listview.setOnItemClickListener(
                    new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long i) {
                            String temp = String.valueOf(parent.getItemAtPosition(position));
                            Log.i(TAG,"item at position " + temp);
                        }
                    }
            );

        } catch (Exception e) {
            Log.i(TAG,"exception!");
            Log.i(TAG,e.toString());
        }


    }
}
