package cn.xxt.customwidget.tablayouttest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import cn.xxt.customwidget.R;

public class TabLayoutTestActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyFragmentAdapter myFragmentAdapter;

    private TabLayout.Tab first;
    private TabLayout.Tab second;
    private TabLayout.Tab third;
    private TabLayout.Tab fourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_tab_layout_test);
        initViews();
    }

    private void initViews() {
        viewPager = findViewById(R.id.view_pager);
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myFragmentAdapter);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        first = tabLayout.getTabAt(0);
        second = tabLayout.getTabAt(1);
        third = tabLayout.getTabAt(2);
        fourth = tabLayout.getTabAt(3);

        first.setIcon(R.mipmap.ic_launcher);
        second.setIcon(R.mipmap.ic_launcher);
        third.setIcon(R.mipmap.ic_launcher);
        fourth.setIcon(R.mipmap.ic_launcher);
    }
}
