package cn.xxt.recyclerviewexercise.transmitdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class MyActivity1 extends AppCompatActivity {

    private TextView tvIntentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        tvIntentData = findViewById(R.id.tv_intent_data);
        //取出intent中的值
        String intentString = getIntent().getStringExtra("intent_string");
        Integer intentInteger = getIntent().getExtras().getInt("intent_integer");
        Data data = (Data)getIntent().getExtras().get("intent_data");

        StringBuilder sb = new StringBuilder();
        sb.append("intent_string:");
        sb.append(intentString);
        sb.append("\n");
        sb.append("intent_integer:");
        sb.append(intentInteger);
        sb.append("\n");
        sb.append("intent_data:");
        sb.append("\n");
        sb.append("data.id:");
        sb.append(data.id);
        sb.append("\n");
        sb.append("data.name:");
        sb.append(data.name);

        tvIntentData.setText(sb.toString());
    }

}
