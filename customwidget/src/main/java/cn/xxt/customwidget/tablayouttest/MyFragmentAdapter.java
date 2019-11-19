package cn.xxt.customwidget.tablayouttest;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @Author zhq
 * @Date 2019-06-19-10:45
 * @Description
 * @Email 1457453696@qq.com
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {

    private String [] mTitles = {"微信", "通讯录", "发现", "我"};

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (0 == i) {
            return new Fragment1();
        } else if (1 == i) {
            return new Fragment2();
        } else if (2 == i) {
            return new Fragment3();
        } else {
            return new Fragment4();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
