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
 * @time 2017/12/19 下午3:41
 */
public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        setTitle("Task ID:" + getTaskId() + ", hashCode:" + this.hashCode());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("Test1Activity", "onNewIntent方法执行");
    }

    public void clickBtnTest1Activity(View view) {
        Intent intent = new Intent(this, Test2Activity.class);
        startActivity(intent);
    }
}
