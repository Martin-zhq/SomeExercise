package cn.xxt.customwidget.gridviewwithindicator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.customwidget.R;
import cn.xxt.customwidget.gridviewwithindicator.indicator.UIndicator;

public class GridViewIndicatorActivity extends AppCompatActivity {
    public static int item_grid_num = 12;//每一页中GridView中item的数量
    public static int number_columns = 4;//gridview一行展示的数目
    private ViewPager view_pager;
    private ViewPagerAdapter mAdapter;
    private List<DataBean> dataList = new ArrayList<>();
    private List<GridView> gridList = new ArrayList<>();
    private UIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_indicator);
        initViews();
    }

    private void initViews() {
        //初始化ViewPager
        view_pager = (ViewPager) findViewById(R.id.view_pager);

        if (dataList.size() > 0) {
            dataList.clear();
        }
        if (gridList.size() > 0) {
            gridList.clear();
        }
        //初始化数据
        for (int i = 0; i < 60; i++) {
            DataBean bean = new DataBean();
            bean.name = "第" + (i + 1) + "条数据";
            dataList.add(bean);
        }
        //计算viewpager一共显示几页
        int pageSize = dataList.size() % item_grid_num == 0
                ? dataList.size() / item_grid_num
                : dataList.size() / item_grid_num + 1;
        for (int i = 0; i < pageSize; i++) {
            GridView gridView = new GridView(this);
            GridViewAdapter adapter = new GridViewAdapter(this, dataList, i, item_grid_num);
            gridView.setNumColumns(number_columns);
            gridView.setAdapter(adapter);
            gridList.add(gridView);
        }

        mAdapter = new ViewPagerAdapter(gridList, this);
        view_pager.setAdapter(mAdapter);
        //指示器
        indicator = findViewById(R.id.indicator);
        indicator.setVisibility(View.VISIBLE);
        indicator.attachToViewPager(view_pager);

        XXTGridMenuView xxtGridMenuView = findViewById(R.id.xxtgrid);
        xxtGridMenuView.setData(null, 5, 5);
        xxtGridMenuView.setXxtGridMenuViewListener(new XXTGridMenuView.XXTGridMenuViewListener() {
            @Override
            public void clickItem(DataBean dataBean) {
                Toast.makeText(GridViewIndicatorActivity.this, dataBean.name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
