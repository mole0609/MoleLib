package com.mole.molelib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mole.molelibrary.LibListener;
import com.mole.molelibrary.LibManager;
import com.mole.molelibrary.LibCallBack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LibManager.getInstance().onClick("hahaha");
            }
        });

        //注册
        LibManager.getInstance().registerListener(listener, callBack);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销注册
        LibManager.getInstance().unRegisterListener();
    }

    //回调数据
    private LibCallBack callBack = new LibCallBack() {
        @Override
        public void onComputeEnd() {

        }

        @Override
        public void sendData(String s) {

        }
    };

    //发送数据
    private LibListener listener = new LibListener() {
        @Override
        public void sendData(String s) {
            TextView view1;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ((TextView) findViewById(R.id.halo)).setText(s);
            }
        }
    };
}