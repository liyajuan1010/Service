package com.example.dell.l_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//BindService能实现Activity与Service交互
public class BindServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBind,btnUnbind,btnAdd;
    private ServiceConnection serviceConnection;
    private MyBindService myBindService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        btnAdd=(Button)findViewById(R.id.btn_add);
        btnBind=(Button)findViewById(R.id.btn_bind);
        btnUnbind=(Button)findViewById(R.id.btn_unbind);
        
        btnUnbind.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                add();
                break;
            case R.id.btn_bind:
                bind();
                break;
            case R.id.btn_unbind:
                unbind();
                break;
        }
    }

    private void add() {
        int result=MyBindService.add(1,2);
        Toast.makeText(this,String.valueOf(result),Toast.LENGTH_LONG).show();
    }

    private void bind() {
        Intent intent=new Intent(BindServiceActivity.this,MyBindService.class);
        serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                //IBinder是用来接收MyBindService中返回的对象
               myBindService=((MyBindService.MyBinder)iBinder).getService();//将iBinder转为MyBindService对象
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
               myBindService=null;
            }
        };
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void unbind() {
        if(serviceConnection!=null){
            unbindService(serviceConnection);
        }
    }
}
