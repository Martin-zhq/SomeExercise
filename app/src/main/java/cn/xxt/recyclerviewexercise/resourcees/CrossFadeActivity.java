package cn.xxt.recyclerviewexercise.resourcees;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import cn.xxt.recyclerviewexercise.R;
/**
 * 
 * @author zhq
 * @time 2017/12/21 下午3:56
 */
public class CrossFadeActivity extends AppCompatActivity {

    private ImageView ivCrossFade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_fade);

        ivCrossFade = findViewById(R.id.iv_cross_fade);
    }

    public void clickBtnMeiziToDragon(View view) {
        TransitionDrawable drawable = (TransitionDrawable) ivCrossFade.getDrawable();
        //从妹子切换到龙，使用1s完成淡入淡出效果
        drawable.startTransition(1000);
    }

    public void clickBtnDragonToMeizi(View view) {
        TransitionDrawable drawable = (TransitionDrawable)ivCrossFade.getDrawable();
        drawable.reverseTransition(1000);
    }
}
