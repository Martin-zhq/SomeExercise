package cn.xxt.recyclerviewexercise.widgetexercise.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressbar extends View {

    private Paint backPaint;

    private Paint frontPaint;

    private Paint textPaint;

    private float strokeWidth = 10;

    private float halfStrokeWidth = strokeWidth / 2;

    private float radius = 200;

    private RectF rect;

    private int progress = 0;

    private int targetProgress = 90;

    private int max = 100;

    private int width;

    private int height;


    public CircleProgressbar(Context context) {
        super(context);
        init();
    }

    public CircleProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        backPaint = new Paint();
        backPaint.setColor(Color.YELLOW);
        backPaint.setAntiAlias(true);
        backPaint.setStyle(Paint.Style.STROKE);
        backPaint.setStrokeWidth(strokeWidth);

        frontPaint = new Paint();
        frontPaint.setColor(Color.GREEN);
        frontPaint.setAntiAlias(true);
        frontPaint.setStyle(Paint.Style.STROKE);
        frontPaint.setStrokeWidth(strokeWidth);

        textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(80);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getRealSize(widthMeasureSpec);
        height = getRealSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        initRect();
        float angle = progress / (float)max * 360;
        canvas.drawCircle(width / 2, height/2, radius, backPaint);
        canvas.drawArc(rect, -90, angle, false, frontPaint);
        canvas.drawText(progress + "%", width/2 + halfStrokeWidth,
                height/2 + halfStrokeWidth, textPaint);

        if (progress < targetProgress) {
            progress += 1;
            invalidate();
        }
    }

    private int getRealSize(int measureSpec) {
        int result = -1;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if (mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED) {
            //自己计算
            result = (int) (radius * 2 + strokeWidth);
        } else {
            result = size;
        }

        return result;
    }

    private void initRect() {
        if (null == rect) {
            rect = new RectF();

            int viewSize = (int) radius*2;
            int left = (width - viewSize) / 2;
            int top = (height - viewSize) / 2;
            int right = left + viewSize;
            int bottom = top + viewSize;
            rect.set(left, top, right, bottom);
        }
    }
}
