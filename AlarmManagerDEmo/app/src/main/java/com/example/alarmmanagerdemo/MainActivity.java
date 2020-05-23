package com.example.alarmmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
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
        c.set(2020,4,17,21,47,0);
        Log.d("TIME", String.valueOf(c.getTime()));
        Log.d("MILLLIIII", String.valueOf(c.getTimeInMillis()));

        if(c.getTimeInMillis() >= Calendar.getInstance().getTimeInMillis())
        {
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Log.d("ALARMAMAGER", "ALARMANGER CREATED");

            Intent intent = new Intent(this, alertReciever.class);
            Log.d("INTENT", "INTENT CREATED");

            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
            Log.d("PENDING", "PENDING INTENT CREATED");

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
            Log.d("ALARMAMAGER", "ALARMMANGER SET");
        }
        else{
            Log.d("Cannot","Start the timer because it was old");
        }
    }

    BroadcastReceiver br = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Log.d("Inside","Mainactivity->broadcastreciever on recieve");
                }
            };
            @Override
            public void onResume() {
                super.onResume();
                registerReceiver(br, new IntentFilter(BroadcastService.COUNTDOWN_BR));
                Log.i("TAG", "Registered broacast receiver");
            }

            @Override
            public void onPause() {
                super.onPause();
                unregisterReceiver(br);
                Log.i("TAG", "Unregistered broacast receiver");
            }

            @Override
            public void onStop() {
                try {
                    unregisterReceiver(br);
                } catch (Exception e) {
                    // Receiver was probably already stopped in onPause()
                }
                super.onStop();
            }

            @Override
            public void onDestroy() {
                stopService(new Intent(this, BroadcastService.class));
                Log.i("TAG", "Stopped service");
                super.onDestroy();
            }

}

//works in every case
//countdowntimer need application running in background<not closed> to work