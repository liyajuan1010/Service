package com.example.dell.l_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart,btnBind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=(Button)findViewById(R.id.btn_start);
        btnBind=(Button)findViewById(R.id.btn_bind);
        btnStart.setOnClickListener(this);
        btnBind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                startActivity(new Intent(MainActivity.this,StartServiceActivity.class));
                break;
            case R.id.btn_bind:
                startActivity(new Intent(MainActivity.this,BindServiceActivity.class));
                break;
        }
    }
}
