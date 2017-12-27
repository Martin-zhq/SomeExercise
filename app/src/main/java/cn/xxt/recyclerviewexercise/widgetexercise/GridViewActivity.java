package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xxt.recyclerviewexercise.R;
/**
 * 网格控件
 * @author zhq
 * @date 2017/12/27 下午7:39
 */
public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        AdapterView.OnItemClickListener{

    private ImageView imageView;

    private GridView gridView;

    private int[] resIds = new int[] {
      R.drawable.face1, R.drawable.face2,R.drawable.face3,R.drawable.face4,
            R.drawable.face5,R.drawable.face6,R.drawable.face7,R.drawable.face8,R.drawable.meizi,
            R.drawable.dragon, R.drawable.face1, R.drawable.face2,R.drawable.face3,R.drawable.face4,
            R.drawable.face5,R.drawable.face6,R.drawable.face7,R.drawable.face8,R.drawable.meizi,
            R.drawable.dragon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.gridView);
        imageView = findViewById(R.id.imageView);

        List<Map<String, Object>> cells = new ArrayList<>();
        for (int i = 0; i < resIds.length; i++) {
            Map<String, Object> cell = new HashMap<>();
            cell.put("iv_cell", resIds[i]);
            cells.add(cell);
        }
        //创建SimpleAdapter对象
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, cells, R.layout.cell, new String[]{"iv_cell"}
        , new int[]{R.id.iv_cell});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);
        gridView.setOnItemSelectedListener(this);
        imageView.setImageResource(resIds[0]);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        imageView.setImageResource(resIds[position]);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        imageView.setImageResource(resIds[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
