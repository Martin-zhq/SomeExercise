package cn.xxt.listviewsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhq
 * @date 2018/6/20 下午7:49
 */
public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;

    private int [] icons = {
            R.drawable.face1, R.drawable.face2, R.drawable.face3
            ,R.drawable.face4, R.drawable.face5, R.drawable.face6
            ,R.drawable.face7, R.drawable.face8
    };

    private String [] names ={
            "魔法棒", "点赞社区", "购物街区", "蚂蚁社区"
            , "陌陌", "贝壳", "小红书", "探探",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_layout);

        gridView = findViewById(R.id.gridview);

        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("icon", icons[i]);
            map.put("name", names[i]);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, list
                ,R.layout.grid_item, new String[]{"icon", "name"}
                ,new int[]{R.id.iv_icon, R.id.tv_name});

        gridView.setAdapter(adapter);
        
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, names[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
