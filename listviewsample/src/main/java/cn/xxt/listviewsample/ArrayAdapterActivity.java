package cn.xxt.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * ArrayAdapter的使用
 * @author zhq
 * @date 2018/6/8 上午11:09
 */
public class ArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        ListView lvArrayAdapter = findViewById(R.id.lv_array_adapter);

        final String [] heros = {"盖伦", "蛮王", "艾希", "维恩", "崔丝塔娜", "卡牌", "奥拉夫", "妖姬", "赵信"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
        , heros);

        lvArrayAdapter.setAdapter(adapter);

        lvArrayAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ArrayAdapterActivity.this, "你选择了英雄：" + heros[position]
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
