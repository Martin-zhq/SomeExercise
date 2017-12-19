package cn.xxt.recyclerviewexercise.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 下午3:12
 */
public class LaunchModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        //设置标题为当前窗口所在任务的id
        setTitle("Task ID:" + getTaskId());
    }

    public void clickBtnStandard(View view) {
        Intent intent = new Intent(this, StandardActivity.class);
        startActivity(intent);
    }

    public void clickBtnSingleTop(View view) {
        Intent intent = new Intent(this, SingleTopActivity.class);
        startActivity(intent);
    }

    public void clickBtnTestActivity(View view) {
        Intent intent = new Intent(this, Test1Activity.class);
        startActivity(intent);
    }

    public void clickBtnSingle(View view) {
        Intent intent = new Intent("cn.xxt.action.SINGLEACTION");
        startActivity(intent);
    }

}
