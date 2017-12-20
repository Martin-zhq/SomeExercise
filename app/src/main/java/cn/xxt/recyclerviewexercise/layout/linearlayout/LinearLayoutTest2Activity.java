package cn.xxt.recyclerviewexercise.layout.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;
import cn.xxt.recyclerviewexercise.layout.framelayout.FrameLayoutTest1Activity;

/**
 *
 * @author zhq
 * @time 2017/12/20 上午9:37
 */
public class LinearLayoutTest2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_test2);
    }

    public void clickBtnCenter(View view) {
        Intent intent = new Intent(this, FrameLayoutTest1Activity.class);
        startActivity(intent);
    }
}
