package cn.xxt.recyclerviewexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhq
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //横向滑动  默认为纵向滑动
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //Grid 横向滑动  默认为上下滑动
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
//        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(layoutManager);

        //瀑布形式上下滑动
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4 , StaggeredGridLayoutManager.VERTICAL);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, MyDividerItemDecoration.VERTICAL_LIST, 20, R.color.colorAccent));
        MyAdapter myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("纵向和横线滚动");
            list.add("纵向和横线瀑布流");
            list.add("添加头布局和脚布局");
            list.add("下拉刷新和上拉加载");
            list.add("多布局页面");
            list.add("滑动删除");
            list.add("点击事件");
            list.add("添加空布局");
            list.add("添加分割线");
        }

    }
}
