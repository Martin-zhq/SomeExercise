package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.xxt.recyclerviewexercise.R;
import cn.xxt.recyclerviewexercise.myimageview.MyImageView;

public class PublishDynamicAdapter extends BaseMultiItemQuickAdapter<DynamicPhotos, BaseViewHolder>{

    private Context context;
    public PublishDynamicAdapter(Context context, List<DynamicPhotos> data) {
        super(data);
        this.context = context;
        addItemType(DynamicPhotos.ADD_PHOTO_TYPE, R.layout.item_publish_dynamic);
        addItemType(DynamicPhotos.PHOTO_TYPE, R.layout.item_publish_dynamic);
    }

    @Override
    protected void convert(BaseViewHolder helper, DynamicPhotos item) {
        switch (helper.getItemViewType()) {
            case DynamicPhotos.ADD_PHOTO_TYPE:
                helper.setImageDrawable(R.id.iv_publish, context.getResources().getDrawable(R.drawable.icon_addpic));
                break;
            case DynamicPhotos.PHOTO_TYPE:
                Picasso.with(context)
                        .load(item.getItemUrl())
                        .placeholder(R.drawable.face1)
                        .error(R.drawable.face1)
                        .into((MyImageView)helper.getView(R.id.iv_publish));
                break;
            default:
                break;
        }
    }
}
