package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2018/3/19.
 */

public class ItemAutoSetHeightAdapter extends BaseQuickAdapter<Url, BaseViewHolder> {

    private List<Url> data;
    private Context context;

    public ItemAutoSetHeightAdapter(Context context, List<Url> data) {
        super(R.layout.item_auto_set_height, data);
        this.data = data;
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Url item) {
        ImageView imageView = helper.getView(R.id.iv_auto_set_height);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(layoutParams);
        imageView.setMaxWidth(layoutParams.width);
        imageView.setMaxHeight(328);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        Picasso.with(context)
                .load(item.getUrl())
                .into(imageView);
    }
}
