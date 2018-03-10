package com.example.dell.l_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="MyService";
    private MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"MyService-->onCreate");
        mediaPlayer=MediaPlayer.create(this,R.raw.zuizaicaoyuan);
        mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"MyService-->onStartCommand");
        String msg=intent.getStringExtra("key");
        Log.i(TAG,msg);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MyService-->onDestroy");
        mediaPlayer.stop();
    }
}
