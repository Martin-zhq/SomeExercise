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
 * @date 2017/12/21 下午6:18
 */
public class RotateActivity extends AppCompatActivity {

    private ImageView ivBeauty1;

    private ImageView ivBeauty2;

    private ImageView ivBeauty3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);

        ivBeauty1 = findViewById(R.id.iv_beauty1);
        ivBeauty2 = findViewById(R.id.iv_beauty2);
        ivBeauty3 = findViewById(R.id.iv_beauty3);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.beauty1);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.beauty2);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.beauty3);

        ivBeauty1.startAnimation(animation1);
        ivBeauty2.startAnimation(animation2);
        ivBeauty3.startAnimation(animation3);
    }
}
