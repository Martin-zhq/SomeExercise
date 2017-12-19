package cn.xxt.recyclerviewexercise.process;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 上午11:01
 */
public class AActivity extends AppCompatActivity {

    private TextView tvContentA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        tvContentA = findViewById(R.id.tv_content_a);
        tvContentA.setText("当前活动所在进程：" + String.valueOf(android.os.Process.myPid()) + "\n");
        tvContentA.append("系统中运行的所有进程为：" + "\n" + ProcessActivity.getAllProcesses(this));
    }

}
