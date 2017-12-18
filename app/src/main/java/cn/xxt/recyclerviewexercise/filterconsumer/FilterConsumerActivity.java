package cn.xxt.recyclerviewexercise.filterconsumer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;

public class FilterConsumerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_consumer);
    }

    public void clickBtnFilter1(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MYACTION1");
        intent.addCategory("android.intent.category.MYCATEGORY1");
        intent.addCategory("android.intent.category.MYCATEGORY2");
        startActivity(intent);
    }

    public void clickBtnFilter2(View view) {
        Intent intent = new Intent("android.intent.action.MYACTION4");
        startActivity(intent);
    }

    public void clickBtnFilter3(View view) {
        Intent intent = new Intent("android.intent.action.MYACTION5");
        intent.setDataAndType(Uri.parse("http://www.microsoft.com:8888/index.html"), "audio/mp3");
        startActivity(intent);
    }

    public void clickBtnFilter4(View view) {
        Intent intent = new Intent("android.intent.action.MYACTION6");
        intent.setDataAndType(Uri.parse("http://www.google.com:8080/work/upload.jsp"), "audio/*");
        startActivity(intent);
    }

    public void clickBtnFilter5(View view) {
        Intent intent = new Intent("android.intent.action.MYACTION7");
        intent.setDataAndType(Uri.parse("ftp://192.168.17.100:8080/work/upload.html"), "audio/*");
        startActivity(intent);
    }

    public void clickBtnFilter6(View view) {
        Intent intent = new Intent("android.intent.action.MYACTION7");
//        intent.setDataAndType(Uri.parse("https://192.168.17.111:8888/work/test.up"), "audio/wav");
//        intent.setDataAndType(Uri.parse("https://192.168.17.111:8888/test/up.aspx"), "audio/wav");
        intent.setDataAndType(Uri.parse("https://192.168.17.111:8888/p/m/abc.html"), "audio/wav");
        startActivity(intent);
    }

}
