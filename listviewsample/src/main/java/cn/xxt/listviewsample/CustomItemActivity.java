package cn.xxt.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 自定义listview
 * @author zhq
 * @date 2018/6/8 上午11:33
 */
public class CustomItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_item);

        ListView lvCustom = findViewById(R.id.lv_custom);

        final String[] heros = {"女枪", "凯特琳", "风女", "女坦", "布隆", "璐璐",
                "奶妈", "伊泽瑞尔", "维鲁斯", "卢锡安", "格雷福斯"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_item
                , R.id.tv_content, heros);

        lvCustom.setAdapter(adapter);

        lvCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomItemActivity.this, "你选择了英雄：" + heros[position]
                        , Toast.LENGTH_SHORT).show();
            }
        });

    }
}
