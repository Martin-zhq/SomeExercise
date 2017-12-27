package cn.xxt.recyclerviewexercise.widgetexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2017/12/27.
 */

public class ViewAdapter extends BaseAdapter {

    private Context context;

    private List<Object> textList = new ArrayList<>();

    public ViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return textList.size();
    }

    @Override
    public Object getItem(int position) {
        return textList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 每显示一个列表项时都会调用getView方法获取列表项的view对象
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(inflater);
        LinearLayout linearLayout = null;
        //处理字符串类型列表项的布局
        if (textList.get(position) instanceof String) {
            linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.item_text_layout, null);
            TextView textView = linearLayout.findViewById(R.id.tv_text);
            //设置列表项的值
            textView.setText(String.valueOf(textList.get(position)));
        } else if (textList.get(position) instanceof Integer) {
            //处理图像类列表项的布局
            linearLayout = (LinearLayout)layoutInflater.inflate(R.layout.item_image_layout, null);
            ImageView imageView = linearLayout.findViewById(R.id.iv_image);
            imageView.setImageResource(Integer.parseInt(String.valueOf(textList.get(position))));
        }
        //返回列表项要使用的布局
        return linearLayout;
    }


    /**
     * 添加文本
     * @param text
     */
    public void addText(String text) {
        textList.add(text);
        notifyDataSetChanged();
    }

    public void addImage(int resId) {
        textList.add(resId);
        notifyDataSetChanged();
    }

    public void remove(int index) {
        if (index < 0) {
            return;
        }
        textList.remove(index);
        notifyDataSetChanged();
    }

    public void modify(int index, String text) {
        if (index < 0) {
            return;
        }
        if (textList.get(index) instanceof String) {
            textList.set(index, text);
            notifyDataSetChanged();
        }
    }

    public void removeAll() {
        textList.clear();
        notifyDataSetChanged();
    }

}

