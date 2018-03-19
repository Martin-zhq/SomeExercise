package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2018/2/28.
 */

public class MyBaseRecyclerViewAdapter extends BaseQuickAdapter<Model, BaseViewHolder> {

    public MyBaseRecyclerViewAdapter(@LayoutRes int layoutResId, @Nullable List<Model> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Model item) {
        helper.setImageResource(R.id.iv_test, R.drawable.face1)
                .setText(R.id.tv_test, item.getTest());
    }
}
