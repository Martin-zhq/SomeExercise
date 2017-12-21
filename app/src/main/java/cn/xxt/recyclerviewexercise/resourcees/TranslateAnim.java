package cn.xxt.recyclerviewexercise.resourcees;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import cn.xxt.recyclerviewexercise.R;
/**
 * 
 * @author zhq
 * @date 2017/12/21 下午5:13
 */
public class TranslateAnim extends AppCompatActivity implements Animation.AnimationListener{

    private EditText etMoving;

    private ImageView ivTranslateDragon;

    private Animation animationRight;

    private Animation animationBottom;

    private Animation animationTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_anim);

        etMoving = findViewById(R.id.et_moving);
        etMoving.setVisibility(View.GONE);
        ivTranslateDragon = findViewById(R.id.iv_translate_dragon);
        //加载动画
        animationRight = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        animationBottom = AnimationUtils.loadAnimation(this, R.anim.translate_bottom);
        animationTop = AnimationUtils.loadAnimation(this, R.anim.translate_top);

        //给动画注册监听事件
        animationBottom.setAnimationListener(this);
        animationTop.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //动画结束后调用此方法
        if (animation.hashCode() == animationBottom.hashCode()) {
            ivTranslateDragon.startAnimation(animationTop);
        } else if (animation.hashCode() == animationTop.hashCode()) {
            ivTranslateDragon.startAnimation(animationBottom);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void clickBtnBeginAnim(View view) {
        //开始etMoving动画
        etMoving.setAnimation(animationRight);
        animationRight.start();
        //设置EditText动画无限循环状态
        animationRight.setRepeatCount(Animation.INFINITE);
        etMoving.setVisibility(View.VISIBLE);
        //开始龙的动画
        ivTranslateDragon.startAnimation(animationBottom);
    }

}
