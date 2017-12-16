package cn.xxt.recyclerviewexercise.transmitdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class MyActivity2 extends AppCompatActivity {

    public static String name;

    public static int id;

    public static Data data;

    private TextView tvStaticData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);

        tvStaticData = findViewById(R.id.tv_static_data);
        StringBuilder sb = new StringBuilder();
        sb.append("name:");
        sb.append(name);
        sb.append("\n");
        sb.append("id:");
        sb.append(id);
        sb.append("\n");
        sb.append("data:");
        sb.append("\n");
        sb.append("data.id:");
        sb.append(data.id);
        sb.append("\n");
        sb.append("data.name:");
        sb.append(data.name);

        tvStaticData.setText(sb.toString());
    }

}
