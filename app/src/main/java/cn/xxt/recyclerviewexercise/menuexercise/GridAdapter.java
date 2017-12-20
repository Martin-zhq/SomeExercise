package cn.xxt.recyclerviewexercise.menuexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 *
 * @author zhq
 * @time 2017/12/20 下午7:37
 */
public class GridAdapter extends BaseAdapter {

    private Context mContext;

    private LayoutInflater mLayoutInflater;

    public GridAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
