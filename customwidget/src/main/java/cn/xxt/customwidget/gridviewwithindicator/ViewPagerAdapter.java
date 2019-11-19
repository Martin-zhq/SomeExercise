package cn.xxt.customwidget.gridviewwithindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * 网格菜单中viewPager适配器
 * @author zhq
 * @date 2019-07-24 11:10
 */
class ViewPagerAdapter extends PagerAdapter {
    private List<GridView> gridList = new ArrayList<>();

    private Context context;

    ViewPagerAdapter(List<GridView> datas, Context context) {
        if (null != datas && datas.size() > 0) {
            gridList.addAll(datas);
        }
        this.context = context;
    }

    @Override
    public int getCount() {
        return gridList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        GridView gridView = gridList.get(position);
        container.addView(gridView);
        return gridView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
