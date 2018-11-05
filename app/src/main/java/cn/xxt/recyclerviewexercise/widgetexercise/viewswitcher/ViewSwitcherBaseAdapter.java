package cn.xxt.recyclerviewexercise.widgetexercise.viewswitcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.xxt.recyclerviewexercise.R;

public class ViewSwitcherBaseAdapter extends BaseAdapter {

    private Context context;

    private List<ViewSwitcherItemData> itemDatas;

    public ViewSwitcherBaseAdapter(Context context, List<ViewSwitcherItemData> itemDatas) {
        this.context = context;
        this.itemDatas = itemDatas;
    }


    @Override
    public int getCount() {
        //这个getCount方法，返回的是每一屏的数量。
        if (ViewSwitcherActivity.screenNo == ViewSwitcherActivity.screenCount - 1
                && itemDatas.size() % ViewSwitcherActivity.NUMBER_PER_SCREEN != 0) {
            return itemDatas.size() % ViewSwitcherActivity.NUMBER_PER_SCREEN;
        } else {
            return ViewSwitcherActivity.NUMBER_PER_SCREEN;
        }
    }

    @Override
    public ViewSwitcherItemData getItem(int position) {
        return itemDatas.get(ViewSwitcherActivity.screenNo * ViewSwitcherActivity.NUMBER_PER_SCREEN + position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder viewHolder;
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_slide_gridview, null);
            viewHolder = new MyViewHolder();
            viewHolder.ivIcon = convertView.findViewById(R.id.iv_icon);
            viewHolder.tvName = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag();
        }

        viewHolder.ivIcon.setImageResource(getItem(position).getIvIcon());
        viewHolder.tvName.setText(getItem(position).getName());

        return convertView;
    }

    private class MyViewHolder {
        ImageView ivIcon;
        TextView tvName;
    }
}
