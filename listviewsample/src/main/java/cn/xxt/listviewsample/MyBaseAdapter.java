package cn.xxt.listviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {

    private Context context;

    private List<Data> datas;

    private int resId;

    public MyBaseAdapter(Context context, List<Data> datas, int resId) {
        this.context = context;
        this.datas = datas;
        this.resId = resId;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (null != datas && datas.size() > 0) {
            count = datas.size();
        }
        return count;
    }

    @Override
    public Data getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resId, parent, false);

            holder = new ViewHolder();

            holder.ivHeader = convertView.findViewById(R.id.iv_header);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvContent = convertView.findViewById(R.id.tv_content);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Data data = getItem(position);
        if (null != data) {
            holder.ivHeader.setImageResource(data.getImgId());
            holder.tvTitle.setText(data.getTitle());
            holder.tvContent.setText(data.getContent());
        }

        return convertView;
    }

    /**
     * 这个东西叫持有者
     */
    private class ViewHolder {
        ImageView ivHeader;
        TextView tvTitle;
        TextView tvContent;
    }
}
