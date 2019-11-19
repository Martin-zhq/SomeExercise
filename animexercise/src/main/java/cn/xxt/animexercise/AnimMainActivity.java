package cn.xxt.animexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * 动画练习
 * @author zhq
 * @date 2019/2/25 下午4:15
 */
public class AnimMainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnScale;
    private Button btnRotate;
    private Button btnTranslate;
    private Button btnAlpha;
    private Button btnSet;
    private TextView tvAnimTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_main);

        initView();
    }

    private void initView() {
        btnScale = findViewById(R.id.btn_scale);
        btnRotate = findViewById(R.id.btn_rotate);
        btnTranslate = findViewById(R.id.btn_translate);
        btnAlpha = findViewById(R.id.btn_alpha);
        btnSet = findViewById(R.id.btn_set);
        tvAnimTest = findViewById(R.id.tv_anim_test);

        btnScale.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btnSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_scale:
                Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
                scaleAnimation.setFillBefore(true);
                scaleAnimation.setRepeatCount(1);
                scaleAnimation.setRepeatMode(Animation.RESTART);
                tvAnimTest.startAnimation(scaleAnimation);
                break;
            case R.id.btn_rotate:
                Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotateanim);
                rotateAnimation.setRepeatCount(1);
                rotateAnimation.setRepeatMode(Animation.RESTART);
                tvAnimTest.startAnimation(rotateAnimation);
                break;
            case R.id.btn_translate:
                Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translateanim);
                translateAnimation.setRepeatCount(1);
                translateAnimation.setRepeatMode(Animation.RESTART);
                tvAnimTest.startAnimation(translateAnimation);
                break;
            case R.id.btn_alpha:
                Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alphaanim);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setRepeatCount(1);
                alphaAnimation.setRepeatMode(Animation.RESTART);
                tvAnimTest.startAnimation(alphaAnimation);
                break;
            case R.id.btn_set:
                AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.setanim);
                tvAnimTest.startAnimation(animationSet);
                break;
            default:
                break;
        }
    }


}
