package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xxt.recyclerviewexercise.R;
/**
 * 下拉列表控件
 * @author zhq
 * @date 2017/12/27 下午4:25
 */
public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner1;

    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spanner2);

        String[] mobileOS = new String[] {"Android", "IPhone", "Symbian", "Meego", "Window Phone7"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mobileOS);
        spinner1.setAdapter(arrayAdapter);

        final List<Map<String, Object>> items = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("ivLogo", R.drawable.face1);
        item1.put("tvApplicationName", "多功能日历");
        Map<String, Object> item2 = new HashMap<>();
        item2.put("ivLogo", R.drawable.face2);
        item2.put("tvApplicationName", "eoeMarket客户端");
        items.add(item1);
        items.add(item2);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, items, R.layout.spinner_item,
                new String[]{"ivLogo", "tvApplicationName"}, new int[] {R.id.ivLogo, R.id.tvApplicationName});
        spinner2.setAdapter(simpleAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setTitle(items.get(position).get("tvApplicationName").toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
