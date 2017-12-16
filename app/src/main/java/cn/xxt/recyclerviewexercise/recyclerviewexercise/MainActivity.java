package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;

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

    /**
     * Created by zhq on 2017/12/15.
     * @author zhq
     */

    public static class Person {

        private int ImageId;

        private String name;

        private String signatuer;

        public int getImageId() {
            return ImageId;
        }

        public void setImageId(int imageId) {
            ImageId = imageId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSignatuer() {
            return signatuer;
        }

        public void setSignatuer(String signatuer) {
            this.signatuer = signatuer;
        }
    }

    /**
     * @author zhq
     */
    public static class ShowDateTime extends AppCompatActivity implements View.OnClickListener{

        private Button btnShowDate;

        private Button btnShowTime;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_date_time);
            setTitle("zenmeshuo");
            btnShowDate = findViewById(R.id.btn_show_date);
            btnShowTime = findViewById(R.id.btn_show_time);
            btnShowDate.setOnClickListener(this);
            btnShowTime.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_show_date:{
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    showDialog("当前日期", sdf.format(new Date()));
                    break;
                }

                case R.id.btn_show_time:{
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    showDialog("当前时间", sdf.format(new Date()));
                    break;
                }

                default:
                    break;
            }
        }

        private void showDialog(String title, String msg) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //设置对话框图标
            builder.setIcon(R.drawable.dialog);
            //标题
            builder.setTitle(title);
            //显示的信息
            builder.setMessage(msg);
            //设置对话框的按钮
            builder.setPositiveButton("确定", null);
            //显示对话框
            builder.create().show();
        }
    }
}
