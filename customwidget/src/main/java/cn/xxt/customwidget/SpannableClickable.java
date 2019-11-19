package cn.xxt.customwidget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;

/**
 * 自定义的ClickableSpan，用以设置字体颜色
 * @author zhq
 * @date 2018/2/9 下午7:07
 */

public abstract class SpannableClickable extends ClickableSpan {
//    private int DEFAULT_COLOR_ID = #8290AF;
    private Context context;
    /**
     * text颜色
     */
    private int textColor ;

    public SpannableClickable(Context context) {
        this.context = context;
        this.textColor = Color.parseColor("#8290AF");
    }

    public SpannableClickable(int textColor){
        this.textColor = textColor;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);

        ds.setColor(textColor);
        ds.setUnderlineText(false);
        ds.clearShadowLayer();
    }
}
