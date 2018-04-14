package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 * RecyclerView实现的网格布局
 * @author zhq
 * @date 2018/4/2 下午7:58
 */
public class PublishDynamicActivity extends AppCompatActivity {

    private RecyclerView rvPhotos;
    private List<DynamicPhotos> datas = new ArrayList<>();
    private PublishDynamicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_dynamic);
        rvPhotos = findViewById(R.id.rv_photos);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rvPhotos.setLayoutManager(gridLayoutManager);

        DynamicPhotos dynamicPhotos1 = new DynamicPhotos(DynamicPhotos.PHOTO_TYPE, "http://f0.topitme.com/0/7a/63/113144393585b637a0o.jpg");
        DynamicPhotos dynamicPhotos2 = new DynamicPhotos(DynamicPhotos.PHOTO_TYPE, "http://www.5857.com/uploadfile/2016/0725/20160725055407737.jpg");
        DynamicPhotos dynamicPhotos3 = new DynamicPhotos(DynamicPhotos.PHOTO_TYPE, "http://www.5857.com/uploadfile/2016/0725/20160725055407737.jpg");
        DynamicPhotos dynamicPhotos = new DynamicPhotos(DynamicPhotos.ADD_PHOTO_TYPE, null);
        datas.add(dynamicPhotos1);
        datas.add(dynamicPhotos2);
        datas.add(dynamicPhotos3);
        datas.add(dynamicPhotos);
        adapter = new PublishDynamicAdapter(this, datas);
        rvPhotos.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (adapter.getItemViewType(position)) {
                    case DynamicPhotos.ADD_PHOTO_TYPE:
                        Toast.makeText(PublishDynamicActivity.this, "点击上传图片", Toast.LENGTH_SHORT).show();
                        break;
                    case DynamicPhotos.PHOTO_TYPE:
                        Toast.makeText(PublishDynamicActivity.this, "点击图片预览", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
