package com.example.foregroundandalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.core.content.ContextCompat;

public class AlertReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data = intent.getExtras();
        String name = data.getString("context");
        if ("alarm".equals(name)) {
            Log.d("ALERTRECIEVER", "ALArm Managger called me");
            Intent serviceIntent = new Intent(context, ForegroundService.class);
            serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android");
            ContextCompat.startForegroundService(context, serviceIntent);
        }
//        else if("foreground".equals(name)){
//
//        }
    }
}
