package cn.xxt.recyclerviewexercise.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 下午3:18
 */
public class StandardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        //将当前活动所在的任务ID和活动对象的hashCode显示在标题栏
        setTitle("Task ID:" + getTaskId() + ", hashCode:" + this.hashCode());
    }

    public void clickBtnStandard1(View view) {
        Intent intent = new Intent(this, StandardActivity.class);
        //再次显示当前标准模式的activity
        startActivity(intent);
    }
}
