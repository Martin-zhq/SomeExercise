package cn.xxt.recyclerviewexercise.layout.framelayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;
import cn.xxt.recyclerviewexercise.layout.relativelayout.RelativeLayoutTestActivity;

public class FrameLayoutTest1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_test1);
    }

    public void clickBtn1(View view) {
        Intent intent = new Intent(this, RelativeLayoutTestActivity.class);
        startActivity(intent);
    }
}
