package cn.xxt.recyclerviewexercise.widgetexercise.adapterviewfilpper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;

import cn.xxt.recyclerviewexercise.R;
/**
 * 原生控件可实现：轮播图
 * @author zhq
 * @date 2018/11/3 下午2:14
 */
public class AdapterViewFlipperActivity extends AppCompatActivity implements View.OnClickListener{

    private MyFilpperAdapter myFilpperAdapter;

    private AdapterViewFlipper filpper;

    private Button btnPrevious;

    private Button btnNext;

    private Button btnAuto;

    private int[] imageIds = {
            R.drawable.dragon, R.drawable.face1, R.drawable.face2, R.drawable.face3, R.drawable.face4,
            R.drawable.face5, R.drawable.face6, R.drawable.face7, R.drawable.face8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);

        initView();
    }

    private void initView() {
        filpper = findViewById(R.id.flipper);
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);
        btnAuto = findViewById(R.id.btn_auto);

        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnAuto.setOnClickListener(this);

        myFilpperAdapter = new MyFilpperAdapter(this, imageIds);
        filpper.setAdapter(myFilpperAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_previous:
                //显示上一张图片
                filpper.showPrevious();
                //停止自动播放
                filpper.stopFlipping();
                break;
            case R.id.btn_next:
                //显示下一张图片
                filpper.showNext();
                //停止自动播放
                filpper.stopFlipping();
                break;

            case R.id.btn_auto:
                //开始自动播放
                filpper.startFlipping();
                break;
            default:
        }
    }
}
