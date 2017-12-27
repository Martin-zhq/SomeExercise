package cn.xxt.recyclerviewexercise.widgetexercise;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.TabHost;

import cn.xxt.recyclerviewexercise.R;


public class TabHostActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        //通过TabActivity类的getTabHost方法获取TabHost对象
        TabHost tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_tab_host, tabHost.getTabContentView()
        , true);
        //添加第一个标签，显示视图
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("切换标签").setContent(R.id.btn_tabhost));
        //添加第二个标签，在标签上显示一个图像
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("相册", getResources().getDrawable(R.drawable.face1))
                .setContent(new Intent(this, GridViewActivity.class)));
        //添加第三个标签
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("评分").setContent(new Intent(this, TextViewImgActivity.class)));

        getTabHost().setCurrentTab(2);
    }
}
