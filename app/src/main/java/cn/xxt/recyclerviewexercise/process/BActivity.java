package cn.xxt.recyclerviewexercise.process;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 上午11:05
 */
public class BActivity extends AppCompatActivity {

    private TextView tvContentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        tvContentB = findViewById(R.id.tv_content_b);
        tvContentB.setText("当前活动所在进程为：" + String.valueOf(android.os.Process.myPid()) + "\n");
        tvContentB.append("系统中所有进程为：" + "\n" + ProcessActivity.getAllProcesses(this));
    }
}
