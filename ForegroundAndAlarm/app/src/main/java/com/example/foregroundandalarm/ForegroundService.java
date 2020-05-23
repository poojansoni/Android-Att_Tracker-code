package com.example.foregroundandalarm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ForegroundService extends Service {
    //Log.d("INSIDE","FOREGROUND SERVICES CALLED");
   // String time = null;
    CountDownTimer cdt = null;
    public static final String CHANNEL_ID = "ForegroundServiceChannel";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("Timer", "Starting timer...");
//3600000   900000
        cdt = new CountDownTimer(3600000, 900000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("TIMER", "Countdown seconds remaining: " + millisUntilFinished / 1000);
                //time = Long.toString(millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Log.i("Tag", "Timer finished");
//                Intent closeIntent = new Intent(getApplicationContext(),AlertReciver.class);
//                closeIntent.putExtra("context","foreground");
//                sendBroadcast(closeIntent);
//                Intent serviceIntent = new Intent(getApplicationContext(), ForegroundService.class);
//                stopService(serviceIntent);
                stopSelf();
                onDestroy();
            }
        };

        cdt.start();

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String input = intent.getStringExtra("inputExtra");
        //createNotificationChannel(); //created App.java that is created instantly hen the app is opened first time same code
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Foreground Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android_icon)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);
//        //do heavy work on a background thread
//        //stopSelf();
        return START_REDELIVER_INTENT; //if system kills the service it will redeliver the older intent to it
    }

//    private void createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel serviceChannel = new NotificationChannel(
//                    CHANNEL_ID,
//                    "Foreground Service Channel",
//                    NotificationManager.IMPORTANCE_DEFAULT
//            );
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(serviceChannel);
//        }
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
