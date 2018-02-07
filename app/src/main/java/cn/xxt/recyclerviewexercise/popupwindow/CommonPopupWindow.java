package cn.xxt.recyclerviewexercise.popupwindow;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by zhq on 2018/2/7.
 */

public class CommonPopupWindow extends PopupWindow{
    final PopupController controller;

    private CommonPopupWindow(Context context) {
        controller = new PopupController(context, this);
    }

    /**
     * 自定义接口，监听popupWindow中的子视图
     */
    public interface ViewInterface {
        void getChildView(View view, int layoutResId);
    }

    /****** 重写PopupWindow中的部分方法 **/

    @Override
    public int getWidth() {
        return controller.mPopupView.getMeasuredWidth();
    }

    @Override
    public int getHeight() {
        return controller.mPopupView.getMeasuredHeight();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        controller.setBackgroundLevel(1.0f);
    }

    /**
     * 建造者模式
     */
    public static class Builder {
        private final PopupController.PopupParams params;
        private ViewInterface listener;

        public Builder(Context context) {
            params = new PopupController.PopupParams(context);
        }

        /**
         * 设置 popupWindow的 布局ID
         * @param layoutResId
         * @return
         */
        public Builder setView(int layoutResId) {
            params.mView = null;
            params.layoutResId = layoutResId;
            return this;
        }

        /**
         * 设置 popupWindow的 布局视图
         * @param view
         * @return
         */
        public Builder setView(View view) {
            params.mView = view;
            params.layoutResId = 0;
            return this;
        }

        /**
         * 设置 popupWindow 的宽和高
         * @param width
         * @param height
         * @return
         */
        public Builder setWidthAndHeight(int width, int height) {
            params.mWidth = width;
            params.mHeight = height;
            return this;
        }

        /**
         * 设置背景灰色程度
         * @param level
         * @return
         */
        public Builder setBackgroundLevel(float level) {
            params.isShowBg = true;
            params.bgLevel = level;
            return this;
        }

        /**
         * 设置是否可点击 popupWindow 的outside消失
         * @param touchable
         * @return
         */
        public Builder setOutsideTouchable(boolean touchable) {
            params.isTouchable = touchable;
            return this;
        }

        /**
         * 设置动画
         * @param animationStyle
         * @return
         */
        public Builder setAnimationStyle(int animationStyle) {
            params.isShowAnim = true;
            params.animationStyle = animationStyle;
            return this;
        }

        /**
         * 设置子view的监听器
         * @param listener
         * @return
         */
        public Builder setViewOnclickListener(ViewInterface listener) {
            this.listener = listener;
            return this;
        }

        public CommonPopupWindow create() {
            final CommonPopupWindow popupWindow = new CommonPopupWindow(params.mContext);
            params.apply(popupWindow.controller);
            if (listener != null && params.layoutResId != 0) {
                listener.getChildView(popupWindow.controller.mPopupView, params.layoutResId);
            }
            CommonUtil.measureWidthAndHeight(popupWindow.controller.mPopupView);
            return popupWindow;
        }
    }
}
