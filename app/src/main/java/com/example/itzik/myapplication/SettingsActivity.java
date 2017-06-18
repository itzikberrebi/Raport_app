package com.example.itzik.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.itzik.myapplication.RAportService.RAportIBinder;

public class SettingsActivity extends Activity {

    RAportService RAservice;
    boolean isBound = false;
    public static final String TAG = "RAport";

    private ServiceConnection RAconnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            RAportIBinder b = (RAportIBinder)service;
            RAservice = b.getService();
            isBound = true;
            Log.i(TAG,"onServiceConnected");

            TextView tv = (TextView) findViewById(R.id.settings_title);
            tv.setText(RAservice.getStringFromService());
            Log.i(TAG,"change text - " + RAservice.getStringFromService());

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate Settings");
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);

            getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5B5BE5")));
            Log.i(TAG,"change actionbar color");

            Intent i = new Intent(this, RAportService.class);
            bindService(i, RAconnection, Context.BIND_AUTO_CREATE);
            Log.i(TAG,"bing service");

        } catch (Exception e) {
            Log.i(TAG,"exception!");
            Log.i(TAG,e.toString());
        }
    }
}
