package com.example.alarmmanagerdemo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;


public class alertReciever extends BroadcastReceiver{
//    CountDownTimer countDownTimer;
//    int count = 0;

    @Override
    public void onReceive(final Context context, Intent intent) {

        Log.d("ALERTRECIEVER","ALArm Managger called me");

        context.startService(new Intent(context, BroadcastService.class));
        Log.d("BROADCASTed", "Started service");


        //intent gets fired at the particular time you set for alarmamangaer
        //here comes the action part
        //har 2 second me chlega ontick range h start to end 60 secs
//        countDownTimer = new CountDownTimer(60000,2000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                count +=1;
//                Log.d("ALERTRECIEVER","COUNTDOWNTIMER IS Counting " + count);
//            }
//
//            @Override
//            public void onFinish() {
//                Log.d("ALERTRECIEVER","COUNTDOWNTIMER IS FINISHED");
//            }
//        };
//
//        countDownTimer.start();
  }

}

