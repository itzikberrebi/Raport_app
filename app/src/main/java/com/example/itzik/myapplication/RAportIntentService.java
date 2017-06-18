package com.example.itzik.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class RAportIntentService extends IntentService {

    public static final String TAG = "RAport";

    public RAportIntentService(){
        super("RAportIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //this is what the service does...
        Log.i(TAG,"The Service Started...");
    }
}
