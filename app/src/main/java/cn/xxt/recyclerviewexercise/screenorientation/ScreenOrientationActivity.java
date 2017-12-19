package cn.xxt.recyclerviewexercise.screenorientation;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;

public class ScreenOrientationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_orientation);
    }

    public void clickBtnFourScreenOrientation(View view) {
        //设置4个屏幕旋转方向，相当于fullSensor
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
    }

    public void clickBtnLandScape(View view) {
        //设置窗口只能横屏， 相当于landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void clickBtnPortrait(View view) {
        //设置窗口只能竖屏，相当于portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
