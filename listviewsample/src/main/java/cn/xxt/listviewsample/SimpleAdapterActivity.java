package cn.xxt.listviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * simpleAdapter简单使用
 * @author zhq
 * @date 2018/6/8 下午3:00
 */
public class SimpleAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        ListView listView = findViewById(R.id.listview);

        SimpleAdapter adapter = new SimpleAdapter(this, getData()
                , R.layout.simple_adapter_item
                , new String[] {"img", "title", "content"}
                , new int[] {R.id.iv_header, R.id.tv_title, R.id.tv_content});

        listView.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("img", R.drawable.face1);
        map.put("title", "盖伦");
        map.put("content", "上单大宝剑");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.face2);
        map.put("title", "剑姬");
        map.put("content", "上单女校长");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.face3);
        map.put("title", "蛮子");
        map.put("content", "上单老蛮王");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.face4);
        map.put("title", "贾克斯");
        map.put("content", "上单单打王");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.face5);
        map.put("title", "鳄鱼");
        map.put("content", "上单线霸");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.face6);
        map.put("title", "狗头");
        map.put("content", "上单发育狗");
        list.add(map);

        return list;
    }
}
