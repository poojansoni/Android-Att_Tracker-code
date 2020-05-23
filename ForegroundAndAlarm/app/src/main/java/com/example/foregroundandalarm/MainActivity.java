package com.example.foregroundandalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();
        Log.d("TIME", String.valueOf(c.getTime()));
        //month is starting from 0??
        c.set(2020,4,18,20,9,30);
        Log.d("TIME", String.valueOf(c.getTime()));
        if(c.getTimeInMillis() >= Calendar.getInstance().getTimeInMillis())
        {
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Log.d("ALARMAMAGER", "ALARMANGER CREATED");

            Intent intent = new Intent(this, AlertReciver.class);
            Log.d("INTENT", "INTENT CREATED");
            intent.putExtra("context","alarm");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
            Log.d("PENDING", "PENDING INTENT CREATED");

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
            Log.d("ALARMAMAGER", "ALARMMANGER SET");
        }
        else{
            Log.d("Cannot","Start the timer because it was old");
        }
    }
}

////in 1 hr for 15 min interval work.
//////for 0, 15, 30, 45  works and ends..or finish function works at 60