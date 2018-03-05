package cn.xxt.recyclerviewexercise.smartrefreshlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import cn.xxt.recyclerviewexercise.R;

/**
 * smartrefreshlayout简单使用
 * @author zhq
 * @date 2018/2/24 上午10:37
 */
public class SmartRefreshLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh_layout);

        RefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //传入false表示刷新失败
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setEnableLoadMore(false);
    }
}
