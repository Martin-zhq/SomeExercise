package cn.xxt.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * 自定义arrayadapter。。
 * @author zhq
 * @date 2018/6/8 上午11:53
 */
public class CustomArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_array_adapter);

        ListView lvCustom = findViewById(R.id.lv_custom);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            list.add(i + "face");
        }
        String[] heros = list.toArray(new String[list.size()]);

        MyArrayAdapter adapter = new MyArrayAdapter(this, R.layout.custom_item, heros);

        lvCustom.setAdapter(adapter);
    }
}
