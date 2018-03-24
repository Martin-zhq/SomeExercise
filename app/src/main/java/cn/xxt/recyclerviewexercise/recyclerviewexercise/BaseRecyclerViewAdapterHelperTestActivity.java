package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 * item 高度自适应
 * @author zhq
 * @date 2018/3/19 下午7:32
 */
public class BaseRecyclerViewAdapterHelperTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycler_view_adapter_helper_test);
        RecyclerView rvAutoSetHeight = findViewById(R.id.rv_item_auto_set_height);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setAutoMeasureEnabled(true);
        rvAutoSetHeight.setLayoutManager(layoutManager);
        List<Url> list = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        urls.add("http://f.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e97f760d908d7912396dd8c9c.jpg");
        urls.add("http://g.hiphotos.baidu.com/image/pic/item/4b90f603738da977c76ab6fab451f8198718e39e.jpg");
        urls.add("http://e.hiphotos.baidu.com/image/pic/item/902397dda144ad343de8b756d4a20cf430ad858f.jpg");
        urls.add("http://a.hiphotos.baidu.com/image/pic/item/a6efce1b9d16fdfa0fbc1ebfb68f8c5495ee7b8b.jpg");
        urls.add("http://b.hiphotos.baidu.com/image/pic/item/a71ea8d3fd1f4134e61e0f90211f95cad1c85e36.jpg");
        urls.add("http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e939011b9c86d07fec54e737d19645.jpg");
        urls.add("http://pica.nipic.com/2007-10-17/20071017111345564_2.jpg");
        urls.add("http://pic4.nipic.com/20091101/3672704_160309066949_2.jpg");
        urls.add("http://pic31.nipic.com/20130624/8821914_104949466000_2.jpg");
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < urls.size(); i++) {
                Url url = new Url();
                url.setUrl(urls.get(i));
                list.add(url);
            }
        }
        ItemAutoSetHeightAdapter adapter = new ItemAutoSetHeightAdapter(this, list);
        rvAutoSetHeight.setAdapter(adapter);
    }
}
