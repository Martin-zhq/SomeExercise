package cn.xxt.recyclerviewexercise.recyclerviewexercise;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2017/12/15.
 * @author zhq
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> myDataList;
    public MyAdapter(List<String> list){
        myDataList = list;
    }

    /**
     * 创建子项item的布局
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_adapter_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 给控件设置数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvMyData.setText(myDataList.get(position));
    }

    /**
     * item数量
     * @return
     */
    @Override
    public int getItemCount() {
        return myDataList.size();
    }

    /**
     * item布局类。
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMyData;
        public ViewHolder(View itemView){
            super(itemView);
            this.tvMyData = itemView.findViewById(R.id.tv_my_data);
        }
    }
}
