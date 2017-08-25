package com.example.sf.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        调用setContentView方法给当前活动添加一个布局
        setContentView(R.layout.first_layout);
    }
}
