package cn.xxt.listviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用baseAdapter的listview
 * @author zhq
 * @date 2018/6/8 下午3:35
 */
public class CustomBaseAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_base_adapter);

        ListView listView = findViewById(R.id.listview);

        View headerView = getLayoutInflater().inflate(R.layout.list_view_header_layout, null);
        View footerView = getLayoutInflater().inflate(R.layout.list_view_footer_layout, null);

        listView.addHeaderView(headerView);
        listView.addFooterView(footerView);

        MyBaseAdapter adapter = new MyBaseAdapter(this, getData(), R.layout.simple_adapter_item);

        listView.setAdapter(adapter);
    }


    private List<Data> getData() {
        List<Data> list = new ArrayList<>();

        list.add(new Data(R.drawable.face1, "盖伦", "上单大宝剑"));
        list.add(new Data(R.drawable.face2, "剑姬", "上单女校长"));
        list.add(new Data(R.drawable.face3, "蛮子", "上单老蛮王"));
        list.add(new Data(R.drawable.face4, "贾克斯", "上单单打王"));
        list.add(new Data(R.drawable.face5, "鳄鱼", "上单线霸"));
        list.add(new Data(R.drawable.face6, "狗头", "上单发育狗"));

        return list;
    }
}
