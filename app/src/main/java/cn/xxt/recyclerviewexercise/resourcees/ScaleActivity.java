package cn.xxt.recyclerviewexercise.resourcees;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/21 下午6:08
 */
public class ScaleActivity extends AppCompatActivity implements Animation.AnimationListener{

    private Animation toSmallAnimation;

    private Animation toLargeAnimation;

    private ImageView ivScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        ivScale = findViewById(R.id.iv_scale);
        toSmallAnimation = AnimationUtils.loadAnimation(this, R.anim.to_small);
        toSmallAnimation.setAnimationListener(this);

        toLargeAnimation = AnimationUtils.loadAnimation(this, R.anim.to_large);
        toLargeAnimation.setAnimationListener(this);

        ivScale.startAnimation(toSmallAnimation);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //动画结束时切换动画
        if (animation.hashCode() == toLargeAnimation.hashCode()) {
            ivScale.startAnimation(toSmallAnimation);
        } else if (animation.hashCode() == toSmallAnimation.hashCode()) {
            ivScale.startAnimation(toLargeAnimation);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
