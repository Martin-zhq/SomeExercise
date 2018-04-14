package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class DynamicPhotos implements MultiItemEntity{
    public static final int ADD_PHOTO_TYPE = 1;
    public static final int PHOTO_TYPE = 2;

    private int itemType;
    private String itemUrl;

    public DynamicPhotos(int itemType, String itemUrl) {
        this.itemType = itemType;
        this.itemUrl = itemUrl;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public String getItemUrl() {
        return itemUrl;
    }
}
