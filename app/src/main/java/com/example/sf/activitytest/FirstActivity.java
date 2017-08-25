package com.example.sf.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        调用setContentView方法给当前活动添加一个布局
        setContentView(R.layout.first_layout);
//        可以通过findViewById方法获取到在布局中定义的元素
//        findViewById()方法返回的是一个View对象，我们需要向下转型为将他向下转型为button对象
        View button1= findViewById(R.id.button1);
        if (button1 instanceof Button){
            Button button=(Button)button1;
//            使用setOnClickListener()方法为button对象注册一个监听器
//            按钮点击事件发生时，就会执行监听器中的onClick()方法
            button.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
//Toast是Android系统中非常好用的提醒方式，在程序中可以使用它将一些短小的信息通知给用户
//                  静态方法makeTest()创建了一个Toast对象，其中有三个参数
//                    1. Context，也就是Toast要求的上下文
//                      2. Toast显示的文本内容
//                    3. Toast显示的时长
//                    调用show()方法将Toast方法显示出来
                    Toast.makeText(FirstActivity.this,"you have clicked button1",Toast.LENGTH_LONG).show();
                }
            });

        }
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                销毁当前对象
                finish();
                Toast.makeText(FirstActivity.this,"active finish",Toast.LENGTH_SHORT).show();
            }
        });
        /*
        * 点击按钮启动另外一个活动*/
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                创建一个Intent对象，使用隐式intent启动一个启动一个活动
                Intent intent=new Intent("android.intent.category.DEFAULT");
//                添加对应的category，此处的添加可以省略，因为添加的是默认的category
                intent.addCategory("android.intent.category.DEFAULT");
//                向下一个action传递数据，第一个参数是键，用于从后面Intent中取值，第二个参数时真正要传递的数据
                intent.putExtra("extra_data","here is the message to next action");
//                使用此方法启动另外一个活动

                //第二个参数是请求码可以自定义，只要唯一就好，用于之后的回调中判断数据的来源
//                使用此方法启动一个活动，在启动的活动被销毁的时候会调用本活动的onActivityResult()来接受反悔的数据
                startActivityForResult(intent,1);
            }
        });
    }
    /*
    * 使用startActivityForResult()方法启动新活动，在新活动销毁的时候自动调用此方法，用于获取新活动返回的数据
    * @param requestCode 启动活动时传入的请求码
    * @param resultCode 返回数据时传入的处理结果
    * @param data 带有返回数据的Intent对象*/
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnMessage=data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnMessage);
                }
                break;
            default:
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * 此方法用于初始化菜单，其中menu参数就是即将要显示的Menu实例。 返回true则显示该menu,false 则不显示;
         * getMenuInflater()方法可以得到MenuInflater对象，再调用它的inflate方法就可以给当前活动创建菜单了
         * 第一个参数用来指明我们将通过哪一个资源文件来创建菜单
         * 第二个参数指定我们的菜单指定到哪一个Menu对象中
         */
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /*
    * 定义菜单的响应事件*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you clicked add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you clicked remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

}
