package cn.xxt.recyclerviewexercise.widgetexercise.stackview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyStackAdapter extends BaseAdapter {

    private Context context;

    private int[] imageIds;

    public MyStackAdapter(Context context, int[] imageIds) {
        this.context = context;
        this.imageIds = imageIds;
    }


    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (null == convertView) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            convertView = imageView;
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imageIds[position]);

        return convertView;
    }
}
