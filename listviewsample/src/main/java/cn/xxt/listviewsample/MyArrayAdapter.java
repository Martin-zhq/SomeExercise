package cn.xxt.listviewsample;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter {

    private Activity context;

    private int resId;

    private String[] items;

    public MyArrayAdapter(Activity context, int resId, String[] items) {
        super(context, resId, items);
        this.context = context;
        this.resId = resId;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View itemView = inflater.inflate(resId, null);

        ImageView ivContent = itemView.findViewById(R.id.iv_content);
        TextView tvContent = itemView.findViewById(R.id.tv_content);

        String content = items[position];

        tvContent.setText(content);

        if (content.startsWith("1")) {
            ivContent.setImageResource(R.drawable.face1);
        } else if (content.startsWith("2")) {
            ivContent.setImageResource(R.drawable.face2);
        } else if (content.startsWith("3")) {
            ivContent.setImageResource(R.drawable.face3);
        } else if (content.startsWith("4")) {
            ivContent.setImageResource(R.drawable.face4);
        } else if (content.startsWith("5")) {
            ivContent.setImageResource(R.drawable.face5);
        } else if (content.startsWith("6")) {
            ivContent.setImageResource(R.drawable.face6);
        } else if (content.startsWith("7")) {
            ivContent.setImageResource(R.drawable.face7);
        } else {
            ivContent.setImageResource(R.drawable.face8);
        }

        return itemView;
    }
}
