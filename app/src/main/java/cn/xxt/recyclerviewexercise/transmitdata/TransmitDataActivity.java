package cn.xxt.recyclerviewexercise.transmitdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.xxt.recyclerviewexercise.R;

public class TransmitDataActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnIntentData;

    private Button btnStaticData;

    private Button btnClipboardData;

    private Button btnApplicationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmit_data);
        initViews();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_intent:

                break;
            case R.id.btn_static_data:

                break;
            case R.id.btn_clipboard_data:

                break;

            case R.id.btn_application_data:

                break;

            default:
                break;
        }

    }

    private void initViews() {
        btnIntentData = findViewById(R.id.btn_intent);
        btnStaticData = findViewById(R.id.btn_static_data);
        btnClipboardData = findViewById(R.id.btn_clipboard_data);
        btnApplicationData = findViewById(R.id.btn_application_data);

        btnIntentData.setOnClickListener(this);
        btnStaticData.setOnClickListener(this);
        btnClipboardData.setOnClickListener(this);
        btnApplicationData.setOnClickListener(this);
    }


}
