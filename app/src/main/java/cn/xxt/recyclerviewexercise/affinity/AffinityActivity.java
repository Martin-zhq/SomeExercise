package cn.xxt.recyclerviewexercise.affinity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 下午5:38
 */
public class AffinityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affinity);

        setTitle("Task ID:" + getTaskId());
    }

    public void clickBtnTaskAffinity(View view) {
        try {
            Intent intent = new Intent("cn.xxt.action.TESTAFFINITYACTION");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "未安装TestAffinity", Toast.LENGTH_SHORT).show();
        }
    }
}
