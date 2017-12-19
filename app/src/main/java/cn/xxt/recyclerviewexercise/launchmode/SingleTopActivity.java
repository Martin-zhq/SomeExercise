package cn.xxt.recyclerviewexercise.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 下午3:28
 */
public class SingleTopActivity extends AppCompatActivity {

    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);

        //title显示 任务id，hashcode
        setTitle("Task ID:" + getTaskId() + ", hashCode:" + this.hashCode());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //singleTop模式下，当前活动在栈顶时不会重新创建这个活动，而是会调用当前活动中的onNewIntent方法。
        Log.d("singleTopActivity", "onNewIntent方法执行" + (i++));
    }

    public void clickBtnSingleTop1(View view) {
        Intent intent = new Intent(this, SingleTopActivity.class);
        startActivity(intent);
    }
}
