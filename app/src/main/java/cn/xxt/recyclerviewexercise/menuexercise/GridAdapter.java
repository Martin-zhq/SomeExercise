package cn.xxt.recyclerviewexercise.menuexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;

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
        return UcMenuConst.GRID_ITEM_ICON_ID_LIST.length;
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
        //返回item布局
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.grid_item, null);
        }
        ImageView ivGridItem = convertView.findViewById(R.id.iv_item_icon);
        TextView tvGridItem = convertView.findViewById(R.id.tv_item_text);
        ivGridItem.setImageResource(UcMenuConst.GRID_ITEM_ICON_ID_LIST[position]);
        tvGridItem.setText(UcMenuConst.GRID_ITEM_TEXT_LIST[position]);

        return convertView;
    }
}
