package cn.xxt.AndroidBlog.jichu23;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ZoomButton;
import android.widget.ZoomControls;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/4/14 下午2:37
 */
public class ZoomButtonActivity extends AppCompatActivity {

    private ZoomButton zbMinus;
    private ZoomButton zbPlus;
    private ZoomControls zc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_button);

        zbMinus = findViewById(R.id.btn_minus);
        zbPlus = findViewById(R.id.btn_plus);
        zc = findViewById(R.id.zc);

        zbMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ZoomButtonActivity.this, "缩小", Toast.LENGTH_SHORT).show();
            }
        });

        zbPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ZoomButtonActivity.this, "放大", Toast.LENGTH_SHORT).show();
            }
        });

        zc.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ZoomButtonActivity.this, "放大", Toast.LENGTH_SHORT).show();
            }
        });

        zc.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ZoomButtonActivity.this, "缩小", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
