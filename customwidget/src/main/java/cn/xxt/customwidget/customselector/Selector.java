package cn.xxt.customwidget.customselector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import cn.xxt.customwidget.R;

/**
 * @Author zhq
 * @Date 2019/2/19-上午9:48
 * @Description 单选按钮  参考：https://juejin.im/post/5c6a31425188256283254aa0
 * @Email 1457453696@qq.com
 */
public abstract class Selector extends FrameLayout implements View.OnClickListener {

    /** 单选按钮唯一标识符 */
    private String mark;

    /** 控制单选的类 */
    private SelectorGroup selectorGroup;

    private OnSelectorStateListener selectorStateListener;

    public Selector(Context context) {
        super(context);
        initView(context, null);
    }

    public Selector(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public Selector(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }

    @Override
    public void onClick(View view) {
        //实现特性2：点击后改变选中状态
        boolean isSelected = switchSelector();
        if (null != selectorGroup) {
            selectorGroup.setSelected(this);
        }
        if (null != selectorStateListener) {
            selectorStateListener.onStateChange(this, isSelected);
        }
    }

    public boolean switchSelector() {
        boolean isSelected = this.isSelected();
        this.setSelected(!isSelected);
        //状态改变时，需要变化的话，由子类去具体实现
        onSwitchSelected(!isSelected);
        return isSelected;
    }

    /**
     * 获取单选按钮身份标志
     * @return
     */
    public String getMark() {
        return this.mark;
    }

    public Selector setSelectorGroup(SelectorGroup selectorGroup) {
        this.selectorGroup = selectorGroup;
        selectorGroup.addSelector(this);
        return this;
    }

    /**
     * 通过继承方法，将父类从配置属性中读取的参数传递给子类
     * @param text
     * @param iconResId
     * @param indicatorResId
     * @param textColorResId
     * @param textSize
     */
    protected abstract void onBindView(String text, int iconResId, int indicatorResId, int textColorResId
            , int textSize);

    /**
     * 子类实现该函数以实现定义单选按钮元素布局
     * @return
     */
    protected abstract View onCreateView();

    /**
     * 状态改变时调用的方法
     * @param isSelected
     */
    protected abstract void onSwitchSelected(boolean isSelected);

    private void initView(Context context, AttributeSet attrs) {
        //将子类定义的view作为子View加入
        View view = onCreateView();
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.MATCH_PARENT);
        this.addView(view, params);
        //实现特性1：可点击
        this.setOnClickListener(this);

        //读取自定义属性
        if (null != attrs) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Selector);
            String text = typedArray.getString(R.styleable.Selector_text);
            int iconResId = typedArray.getResourceId(R.styleable.Selector_img, 0);
            int selectorResId = typedArray.getResourceId(R.styleable.Selector_indicator, 0);
            int textColor = typedArray.getColor(R.styleable.Selector_text_color, Color.BLACK);
            int textSize = typedArray.getInteger(R.styleable.Selector_text_size, 15);
            mark = typedArray.getString(R.styleable.Selector_mark);
            //将获取到的属性，传递给子类
            onBindView(text, iconResId, selectorResId, textColor, textSize);
            typedArray.recycle();
        }
    }

    @Override
    public int hashCode() {
        return this.mark.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Selector) {
            return ((Selector) obj).mark.equals(this.mark);
        }
        return false;
    }

    public Selector setSelectorStateListener(OnSelectorStateListener onSelectorStateListener) {
        this.selectorStateListener = onSelectorStateListener;
        return this;
    }

    public interface OnSelectorStateListener {
        void onStateChange(Selector selector, boolean isSelected);
    }
}
