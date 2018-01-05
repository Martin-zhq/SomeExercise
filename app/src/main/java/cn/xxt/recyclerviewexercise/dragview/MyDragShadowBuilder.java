package cn.xxt.recyclerviewexercise.dragview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/**
 * 自定义的拖动阴影类，需继承自View.DragShadowBuilder
 * @author zhq
 * @date 2018/1/5 下午3:38
 */
public class MyDragShadowBuilder extends View.DragShadowBuilder {

    /** 拖动阴影的区域 */
    private static Drawable shadow;

    /** 存储新绘制的拖动阴影图像 */
    private static Bitmap newBitmap;

    /**
     *
     * @param view 本例中view为ImageView
     */
    public MyDragShadowBuilder(View view) {
        super(view);
        //初始化了这个拖动阴影区域
        shadow = new ColorDrawable(Color.LTGRAY);
    }

    @Override
    public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {

        int width, height;

        //拖动阴影图像的宽度，高度，比被拖动图像大50%
        width = (int)(getView().getWidth() * 1.5);
        height = (int)(getView().getHeight() * 1.5);

        //设置拖动阴影图像绘制的区域
        shadow.setBounds(0, 0, width, height);
        //设置拖动阴影图像的宽度和高度
        outShadowSize.set(width, height);
        // 设置手指或鼠标在拖动阴影图像的位置，本例设置在图像的中心位置
        outShadowTouchPoint.set(width/2, height/2);

        //判断传入的view是否为ImageView
        if (getView() instanceof ImageView) {

            ImageView imageView = (ImageView) getView();
            //获取传入的ImageView的drawable对象
            Drawable drawable = imageView.getDrawable();
            //获取ImageView中的图像资源，从drawable中获取
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            //根据拖动阴影图像的尺寸创建一个新的可绘制的Bitmap图像
            newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            //将canvas和Bitmap关联
            Canvas canvas = new Canvas(newBitmap);
            //将bitmap放大50%，然后绘制在newBitmap上面。
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(),bitmap.getHeight()),
                    new Rect(0, 0, width, height), null);
        }
    }

    @Override
    public void onDrawShadow(Canvas canvas) {
        //将图像正式绘制在拖动阴影图像上
        canvas.drawBitmap(newBitmap, 0, 0, new Paint());
    }
}
