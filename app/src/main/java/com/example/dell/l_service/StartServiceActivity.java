package com.example.dell.l_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*法一：New--Service---Service
法二：Class--输入MyService，在第三行选继承Service(android.app包中)，此方法需要在Manifest中注册
 */
public class StartServiceActivity extends AppCompatActivity implements View.OnClickListener {
     private Button btnStart,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        btnStart=(Button)findViewById(R.id.btn_start);
        btnStop=(Button)findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                start();
                break;
            case R.id.btn_stop:
                stop();
                break;
        }
    }

    private void start() {
        Intent intent=new Intent(StartServiceActivity.this,MyService.class);
        intent.putExtra("key","Service传值测试");
        startService(intent);
    }

    private void stop() {
        Intent intent=new Intent(StartServiceActivity.this,MyService.class);
        stopService(intent);
    }
}
