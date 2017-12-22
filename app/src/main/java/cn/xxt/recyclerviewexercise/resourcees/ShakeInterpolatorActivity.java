package cn.xxt.recyclerviewexercise.resourcees;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/22 上午9:19
 */
public class ShakeInterpolatorActivity extends AppCompatActivity {

    private EditText etShakeInterpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_interpolator);

        etShakeInterpolator = findViewById(R.id.et_shake_interpolator);
    }

    public void clickBtnShake(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake);
        animation.setRepeatCount(Animation.INFINITE);
        etShakeInterpolator.startAnimation(animation);
    }
}
