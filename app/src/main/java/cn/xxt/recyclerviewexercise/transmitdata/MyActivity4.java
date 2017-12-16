package cn.xxt.recyclerviewexercise.transmitdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;

public class MyActivity4 extends AppCompatActivity {

    private TextView tvApplicationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my4);

        tvApplicationData = findViewById(R.id.tv_application_data);
        MyApp myApp = (MyApp)getApplicationContext();
        tvApplicationData.setText("country:" + myApp.country + "\ndata.id:" + myApp.data.id
        + "\ndata.name:" + myApp.data.name);
    }
}
