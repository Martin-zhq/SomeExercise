package cn.xxt.recyclerviewexercise.intentflag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 下午5:05
 */
public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my5);

        setTitle("Task ID:" + getTaskId() + ", hashCode:" + this.hashCode());
    }

    public void clickBtnMyActivity1(View view) {
        Intent intent = new Intent(this, this.getClass());
        startActivity(intent);
    }

    public void clickBtnCloseAllMyActivity(View view) {
        //关闭所有MyActivity活动
        Intent intent = new Intent(this, IntentFlagActivity.class);
        //同时使用SINGLE_TOP和CLEAR_TOP,相当于将IntentFlagActivity设置为singleTask模式
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
