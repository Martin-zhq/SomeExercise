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
 * @time 2017/12/19 下午3:43
 */
public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        setTitle("Task ID:" + getTaskId() + ", hashCode:" + this.hashCode());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Test2Activity", "onDestroy()方法执行");
    }

    public void clickBtnTest2Activity(View view) {
        Intent intent = new Intent(this, Test1Activity.class);
        //跳转时，如果Test1Activity存在，则此活动被销毁。
        startActivity(intent);
    }

}
