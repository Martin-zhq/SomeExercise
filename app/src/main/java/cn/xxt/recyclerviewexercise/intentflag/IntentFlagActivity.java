package cn.xxt.recyclerviewexercise.intentflag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 下午4:36
 */
public class IntentFlagActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_flag);
        setTitle("Task ID:" + getTaskId() + ", hashCode:" + this.hashCode());
    }

    public void clickBtnShowSelf(View view) {
        Intent intent = new Intent(this, this.getClass());
        //相当于singleTop模式。
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void clickBtnMyActivity(View view) {
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
    }

    public void clickBtnSingleTask(View view) {
        try {
            Intent intent = new Intent("cn.xxt.action.ACTION_NEW_ACTIVITY");
            //设置NEW_TASK标志   相当于显示single程序中的singleTask模式的窗口。
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Single程序不存在！", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickBtnStandard2(View view) {
        try {
            Intent intent = new Intent("cn.xxt.action.ACTION_NEW_ACTIVITY");
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Single程序不存在！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("IntentFlagActivity", "onNewIntent方法执行了。");
    }
}
