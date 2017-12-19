package cn.xxt.recyclerviewexercise.process;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class ProcessActivity extends AppCompatActivity {

    private TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        tvContent = findViewById(R.id.tv_content);
        String processId = String.valueOf(android.os.Process.myPid());
        //将信息展示到textView中
        tvContent.setText("当前活动所在进程ID：" + processId + "\n");
        tvContent.append("系统中运行所有进程名称为：\n" + getAllProcesses(this));
    }

    public static String getAllProcesses(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        //获取系统服务对象(ActivityManager对象)
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        //遍历已运行进程，将其名称和id加入到sb中
        for (ActivityManager.RunningAppProcessInfo info : activityManager.getRunningAppProcesses()) {
            stringBuilder.append(info.processName + "(" + info.pid + ")\n");
        }
        return stringBuilder.toString();
    }

    public void clickBtnUseOldProcess(View view) {
        Intent intent = new Intent(this, BActivity.class);
        //显示B界面，仍使用当前应用程序的默认进程
        startActivity(intent);
    }

    public void clickBtnCreateNewProcess(View view) {
        Intent intent = new Intent(this, AActivity.class);
        //创建新进程显示活动A
        startActivity(intent);
    }
}
