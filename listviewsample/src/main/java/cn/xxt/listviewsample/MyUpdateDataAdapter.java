package cn.xxt.listviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MyUpdateDataAdapter extends BaseAdapter {

    private Context context;

    private List<UpdateData> updateDataList;

    public MyUpdateDataAdapter() {

    }

    public MyUpdateDataAdapter(Context context, List<UpdateData> updateDataList) {
        this.context = context;
        this.updateDataList = updateDataList;
    }

    /**
     * 添加数据
     * @param position
     * @param updateData
     */
    public void add(int position, UpdateData updateData) {
        if (null == updateDataList) {
            updateDataList = new LinkedList<>();
        }
        updateDataList.add(position, updateData);
        notifyDataSetChanged();
    }

    /**
     * 更新列表所有数据
     * @param list
     */
    public void update(List<UpdateData> list) {
        if (null == updateDataList) {
            updateDataList = new LinkedList<>();
        }

        updateDataList.clear();
        updateDataList.addAll(list);

        notifyDataSetChanged();
    }

    /**
     * 更新列表项某条数据
     * @param position
     * @param data
     */
    public void update(int position, UpdateData data) {
        if (null != updateDataList && position < updateDataList.size()) {
            updateDataList.set(position, data);
        }
        notifyDataSetChanged();
    }

    /**
     * 移除某项数据
     * @param position
     */
    public void remove(int position) {
        if (null != updateDataList && 0 != getCount()) {
            updateDataList.remove(position);
        }
        notifyDataSetChanged();
    }

    /**
     * 清空列表
     */
    public void clear() {
        if (null != updateDataList) {
            updateDataList.clear();
        }
        notifyDataSetChanged();
    }


    @Override
    public UpdateData getItem(int position) {
        return updateDataList.get(position);
    }

    @Override
    public int getCount() {
        int count = 0;
        if (null != updateDataList && updateDataList.size() > 0) {
            count = updateDataList.size();
        }
        return count;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.update_data_item, null);

            viewHolder = new ViewHolder();
            viewHolder.ivHeader = convertView.findViewById(R.id.img_header);
            viewHolder.tvContent = convertView.findViewById(R.id.tv_content);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        UpdateData data = getItem(position);
        viewHolder.ivHeader.setImageResource(data.getImgId());
        viewHolder.tvContent.setText(data.getContent());
        return convertView;
    }

    private class ViewHolder {
        ImageView ivHeader;
        TextView tvContent;
    }
}
