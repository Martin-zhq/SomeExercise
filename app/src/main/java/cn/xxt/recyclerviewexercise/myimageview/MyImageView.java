package cn.xxt.recyclerviewexercise.myimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import cn.xxt.recyclerviewexercise.R;

/**
 * 自定义可设置宽高比图片
 * @author zhq
 * @date 2018/3/20 上午9:47
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView{
    //宽高比
    private float ratio;


    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyImageView);
        ratio = typedArray.getFloat(R.styleable.MyImageView_ratio, 0.0f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取宽度的模式和尺寸
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //获取高度的模式和尺寸
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //宽确定，高不确定
        if (widthMode == MeasureSpec.EXACTLY && heightMode!=MeasureSpec.EXACTLY && ratio!= 0) {
            //根据宽度和比例计算高度
            heightSize = (int) (widthSize*ratio + 0.5f);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY);
        } else if (widthMode != MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY && ratio != 0) {
            widthSize = (int) (heightSize/ratio+0.5f);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize, MeasureSpec.EXACTLY);
        } else {
            throw new RuntimeException("无法设定宽高比");
        }
        //调用该方法完成onMeasure的重写
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 设置宽高比
     */
    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}
