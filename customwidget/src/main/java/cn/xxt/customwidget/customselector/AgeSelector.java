package cn.xxt.customwidget.customselector;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import cn.xxt.customwidget.R;

/**
 * @Author zhq
 * @Date 2019/2/19-上午10:35
 * @Description 分年龄段单选按钮
 * @Email 1457453696@qq.com
 */
public class AgeSelector extends Selector {

    private TextView tvTitle;

    private ImageView ivIcon;

    private ImageView ivSelector;

    private ValueAnimator valueAnimator;

    public AgeSelector(Context context) {
        super(context);
    }

    public AgeSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AgeSelector(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.age_selector, null);
        tvTitle = view.findViewById(R.id.tv_title);
        ivIcon = view.findViewById(R.id.iv_icon);
        ivSelector = view.findViewById(R.id.iv_selector);

        return view;
    }

    @Override
    protected void onBindView(String text, int iconResId, int indicatorResId, int textColorResId
            , int textSize) {
        //设置自定义布局中的控件的值
        if (null != tvTitle) {
            tvTitle.setText(text);
            tvTitle.setTextColor(textColorResId);
            tvTitle.setTextSize(textSize);
        }
        if (null != ivIcon) {
            ivIcon.setImageResource(iconResId);
        }
        if (null != ivSelector) {
            ivSelector.setImageResource(indicatorResId);
            ivSelector.setAlpha(0);
        }
    }

    @Override
    protected void onSwitchSelected(boolean isSelected) {
        //是否被选中的状态改变时，需要做的操作
        if (isSelected) {
            playSelectedAnimation();
        } else {
            playUnselectedAnimation();
        }
    }

    /**
     * 播放取消选中的动画效果
     */
    private void playUnselectedAnimation() {
        if (ivSelector == null) {
            return;
        }
        if (null != valueAnimator) {
            valueAnimator.reverse();
        }
    }

    /**
     * 播放选中的动画效果
     */
    private void playSelectedAnimation() {
        if (null == ivSelector) {
            return;
        }
        valueAnimator = ValueAnimator.ofInt(0, 255);
        valueAnimator.setDuration(400);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ivSelector.setAlpha((int)valueAnimator.getAnimatedValue());
            }
        });
        valueAnimator.start();
    }
}
