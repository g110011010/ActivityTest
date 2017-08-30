package com.example.sf.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //                获取用于启动本action的intent
        Intent getString=getIntent();
//                获取传入的数据
        String message=getString.getStringExtra("extra_data");
        System.out.println(message);
//                输出获取的数据到日志a
        /**
        *
        *@param
        *@return
        *@author
        */
        Log.d("SecondActivity", message);
        setContentView(R.layout.activity_second);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "this is second activity", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.back_activity1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("data_return","Hello,this is the message to the up action");
//               是专门用于向上一个方法返回数据的，第一个参数用于向上一个活动返回处理结果，第二个参数返回带有返回数据的intent对象
                setResult(RESULT_OK,intent);
                finish();
            }
        });
//        点击按钮使用系统默认浏览器打开百度首页
        findViewById(R.id.baidu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                指定action为android系统内置的action
                Intent intent=new Intent(Intent.ACTION_VIEW);
//                setDate()用于指定当前Intent正在操作的数据
//                Uri.parse()将一个网址字符串解析为一个Uri对象
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}
