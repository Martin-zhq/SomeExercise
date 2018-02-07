package cn.xxt.recyclerviewexercise.popupwindow;

import android.view.View;

/**
 * Created by zhq on 2018/2/7.
 */

public class CommonUtil {

    /**
     * 测量View的宽高
     * @param view
     */
    public static void measureWidthAndHeight(View view) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(widthMeasureSpec, heightMeasureSpec);
    }
}
