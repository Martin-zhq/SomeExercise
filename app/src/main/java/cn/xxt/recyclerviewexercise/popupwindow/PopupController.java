package cn.xxt.recyclerviewexercise.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by zhq on 2018/2/7.
 */

public class PopupController {
    /** 布局id */
    private int layoutResId;
    /** 布局视图 */
    private View mView;

    private Context context;
    private PopupWindow popupWindow;
    /** 弹窗布局View */
    View mPopupView;
    private Window mWindow;

    PopupController(Context context, PopupWindow popupWindow) {
        this.context = context;
        this.popupWindow = popupWindow;
    }

    /**
     * 设置 popupWindow 中的布局id
     * @param layoutResId
     */
    public void setView(int layoutResId) {
        mView = null;
        this.layoutResId = layoutResId;
        installContent();
    }

    /**
     * 设置popupWindow中的布局视图
     * @param view
     */
    public void setView(View view) {
        mView = view;
        this.layoutResId = 0;
        installContent();
    }

    /**
     * 设置popupWindow中的布局内容
     */
    private void installContent() {
        if (layoutResId != 0) {
            mPopupView = LayoutInflater.from(context).inflate(layoutResId, null);
        } else if (mView != null) {
            mPopupView = mView;
        }
        popupWindow.setContentView(mPopupView);
    }

    /**
     * 设置popupWindow的宽高
     * @param width
     * @param height
     */
    private void setWidthAndHeight(int width, int height) {
        if (width == 0 || height == 0) {
            //没有设置，默认是WRAP_CONTENT
            popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        } else {
            popupWindow.setWidth(width);
            popupWindow.setHeight(height);
        }
    }

    /**
     * 设置 当前屏幕的 背景灰色程度
     * @param level 0.0-1.0
     */
    public void setBackgroundLevel(float level) {
        mWindow = ((Activity)context).getWindow();
        WindowManager.LayoutParams params = mWindow.getAttributes();
        params.alpha = level;
        mWindow.setAttributes(params);
    }

    /**
     * 设置popupWindow的动画效果
     * @param animationStyle
     */
    private void setAnimationStyle(int animationStyle) {
        popupWindow.setAnimationStyle(animationStyle);
    }

    /**
     * 设置popupWindow 的 Outside是否可以点击
     * @param touchable
     */
    private void setOutsideTouchable(boolean touchable) {
        //必须设置这个背景为透明
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //设置outside可点击
        popupWindow.setOutsideTouchable(touchable);
        popupWindow.setFocusable(touchable);
    }


    static class PopupParams {
        /** popupWindow的布局ID */
        public int layoutResId;
        /** popupWindow的布局视图 */
        public View mView;

        public Context mContext;
        /** popupWindow的宽高 */
        public int mWidth, mHeight;
        /** 是否设置背景和是否显示动画的标志位 */
        public boolean isShowBg, isShowAnim;
        /** 屏幕背景的灰色程度 */
        public float bgLevel;
        /** 动画资源id */
        public int animationStyle;
        /** 外部是否可点击，默认可点击 */
        public boolean isTouchable = true;

        public PopupParams(Context mContext) {
            this.mContext = mContext;
        }

        public void apply(PopupController controller) {
            if (null != mView) {
                controller.setView(mView);
            } else if (layoutResId != 0) {
                controller.setView(layoutResId);
            } else {
                throw new IllegalArgumentException("PopupView's contentView is null");
            }
            controller.setWidthAndHeight(mWidth, mHeight);
            //设置外部可点击
            controller.setOutsideTouchable(isTouchable);
            if (isShowBg) {
                //设置背景
                controller.setBackgroundLevel(bgLevel);
            }
            if (isShowAnim) {
                //设置动画
                controller.setAnimationStyle(animationStyle);
            }
        }


    }

}

