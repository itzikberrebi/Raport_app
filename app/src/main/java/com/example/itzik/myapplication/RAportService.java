package com.example.itzik.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class RAportService extends Service {

    private final IBinder RAportBinder = new RAportIBinder();

    public RAportService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return RAportBinder;
    }

    public String getStringFromService(){
        return "StirngService";
    }

    public class RAportIBinder extends Binder {
        RAportService getService(){
            return RAportService.this;
        }
    }
}
