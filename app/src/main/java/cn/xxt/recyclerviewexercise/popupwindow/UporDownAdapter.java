package cn.xxt.recyclerviewexercise.popupwindow;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2018/3/24.
 */

public class UporDownAdapter extends BaseQuickAdapter<ButtonText, BaseViewHolder> {

    private Context context;

    public UporDownAdapter(Context context, List<ButtonText> datas) {
        super(R.layout.item_up_or_down, datas);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ButtonText item) {
        helper.setText(R.id.btn_popup, item.getText())
                .addOnClickListener(R.id.btn_popup);

    }
}
