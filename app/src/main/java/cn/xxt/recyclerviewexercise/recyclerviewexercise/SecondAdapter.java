package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2017/12/15.
 */

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    private List<MainActivity.Person> personList;

    private SecondListener secondListener = null;

    public SecondAdapter(List<MainActivity.Person> list) {
        personList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_adapter_item_layout
                , parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        MainActivity.Person person = personList.get(position);
        holder.ivHead.setImageResource(person.getImageId());
        holder.tvName.setText(person.getName());
        holder.tvSignature.setText(person.getSignatuer());
        //注册点击事件
        holder.rlWhole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用接口中点击方法
                if (secondListener != null) {
                    secondListener.clickSecondAdapterItem(position);
                }
            }
        });
        holder.ivHead.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("对话框标题")
                        .setNegativeButton("取消按钮", null)
                        .setPositiveButton("确定按钮", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), "点击了确定按钮", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivHead;
        private TextView tvName;
        private TextView tvSignature;
        private RelativeLayout rlWhole;

        public ViewHolder(View view){
            super(view);
            ivHead = view.findViewById(R.id.iv_head);
            tvName = view.findViewById(R.id.tv_name);
            tvSignature = view.findViewById(R.id.tv_signature);
            rlWhole = view.findViewById(R.id.rl_whole);
        }
    }


    /**自定义接口*/
    public interface SecondListener {

        void clickSecondAdapterItem(int position);

    }

    public void setSecondListener(SecondListener listener) {
        secondListener = listener;
    }

}
