package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhq on 2017/12/15.
 * @author zhq
 */
public class MyDividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[] {
           android.R.attr.listDivider
   };

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private int orientation;
    private Drawable divider;
    /** 默认是2px */
    private int divierHeight = 2;
    private Paint paint;

    /**
     * 绘制默认分割线
     * @param context
     * @param orientation
     */
    public MyDividerItemDecoration(Context context, int orientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        divider = a.getDrawable(0);
        //从系统属性中获取
        a.recycle();
        setOrientation(orientation);
    }

    /**
     * 自定义分割线
     * @param context
     * @param orientation 列表方向
     * @param drawableId 分割线图片
     */
    public MyDividerItemDecoration(Context context, int orientation, int drawableId) {
        this(context, orientation);
        divider = ContextCompat.getDrawable(context, drawableId);
        divierHeight = divider.getIntrinsicHeight();
    }

    /**
     * 自定义
     * @param context
     * @param orientation 列表方向
     * @param divierHeight 分割线高度
     * @param dividerColor 分割线颜色
     */
    public MyDividerItemDecoration(Context context, int orientation, int divierHeight
    , int dividerColor) {
        this(context, orientation);
        this.divierHeight = divierHeight;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(dividerColor);
        paint.setStyle(Paint.Style.FILL);
    }

    private void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.orientation = orientation;
    }

    /**
     * 在recyclerview的onDraw中执行    绘制的方法
     * @param c
     * @param parent
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
       if (orientation == VERTICAL_LIST) {
           drawVertical(c, parent);
       } else {
           drawHorizontal(c, parent);
       }
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView v = new RecyclerView(parent.getContext());
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)
                    child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount-1; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    /**
     * 绘制的区域
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (orientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, divierHeight);
        } else {
            outRect.set(0, 0, divierHeight, 0);
        }
    }
}

