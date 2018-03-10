package com.example.dell.l_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {
    private static final String TAG="MyBindService";
    public MyBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(TAG,"MyBindService-->onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"MyBindService-->onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MyBindService-->onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"MyBindService-->onUnbind");
        return super.onUnbind(intent);
    }
    public static int add(int a, int b){
        return a+b;
    }

    public class MyBinder extends Binder {//实现了Binder接口，也可以用implements
       public  MyBindService getService(){
           return MyBindService.this;//返回BindService实例对象，调用get时返回该值
       }
    }
}
