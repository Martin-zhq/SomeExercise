package cn.xxt.AndroidBlog.jichu24;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
/**
 * 简单的自定义view
 * @author zhq
 * @date 2018/4/14 下午3:03
 */
public class CustomView extends View {

    /**画笔*/
    private Paint mpaint;
    /** 用于获取文字的宽高 */
    private Rect mBounds;
    /** 记录点击次数 */
    private int mCount = 0;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //初始化画笔
        mpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                //重绘
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔颜色
        mpaint.setColor(Color.YELLOW);
        //绘制矩形
        canvas.drawRect(0, 0, getWidth(), getHeight(), mpaint);

        //改变画笔颜色
        mpaint.setColor(Color.RED);
        //设置文本大小
        mpaint.setTextSize(50);
        String text = String.valueOf(mCount);
        //获取文字的宽度和高度
        mpaint.getTextBounds(text, 0, text.length(), mBounds);

        float textWidth = mBounds.width();
        float textHeight = mBounds.height();

        //绘制字符串
        canvas.drawText(text, getWidth()/2 - textWidth/2, getHeight()/2 + textHeight/2, mpaint);
    }
}
