package cn.xxt.recyclerviewexercise.widgetexercise;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/**
 * 自定的可以同时设置背景和前景色的span类
 * @author zhq
 * @date 2017/12/22 下午4:48
 */

public class ColorSpan extends CharacterStyle {

    private int mTextColor;

    private int mBackgroundColor;

    public ColorSpan(int textColor, int backgroundColor) {
        mTextColor = textColor;
        mBackgroundColor = backgroundColor;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        //重写父类的这个方法，在其中设置文字和背景的颜色
        tp.bgColor = mBackgroundColor;
        tp.setColor(mTextColor);
    }
}
