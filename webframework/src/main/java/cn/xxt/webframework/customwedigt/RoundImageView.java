package cn.xxt.webframework.customwedigt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

public class RoundImageView extends AppCompatImageView {
    float width,height;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (width > 8 && height > 8) {
            Path path = new Path();
            path.moveTo(8, 0);
            path.lineTo(width - 8, 0);
            path.quadTo(width, 0, width, 8);
            path.lineTo(width, height - 8);
            path.quadTo(width, height, width - 8, height);
            path.lineTo(8, height);
            path.quadTo(0, height, 0, height - 8);
            path.lineTo(0, 8);
            path.quadTo(0, 0, 8, 0);
            canvas.clipPath(path);
        }

        super.onDraw(canvas);
    }
}
