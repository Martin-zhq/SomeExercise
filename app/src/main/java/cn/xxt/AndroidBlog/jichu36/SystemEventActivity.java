package cn.xxt.AndroidBlog.jichu36;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;

/**
 * 系统配置了解
 * @author zhq
 * @date 2018/6/8 上午9:38
 */
public class SystemEventActivity extends AppCompatActivity {

    private TextView tvSystemConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_event);

        tvSystemConfiguration = findViewById(R.id.tv_system_configuration);
        //获取系统configuration对象
        Configuration cfg = getResources().getConfiguration();

        StringBuffer status = new StringBuffer();
        status.append("屏幕密度：" + cfg.densityDpi + "\n");
        status.append("字体缩放因子：" + cfg.fontScale + "\n");
        status.append("硬键盘是否可见：" + cfg.hardKeyboardHidden + "\n");
        status.append("键盘类型：" + cfg.keyboard + "\n");
        status.append("当前键盘是否可用：" + cfg.keyboardHidden + "\n");
        status.append("语言环境：" + cfg.locale + "\n");
        status.append("移动信号的国家码：" + cfg.mcc + "\n");
        status.append("移动信号的网络码：" + cfg.mnc + "\n");
        status.append("方向导航设备的类型：" + cfg.navigation + "\n");
        status.append("方向导航设备是否可用：" + cfg.navigationHidden + "\n");
        status.append("系统屏幕的方向：" + cfg.orientation + "\n");
        status.append("屏幕可用高：" + cfg.screenHeightDp + "\n");
        status.append("屏幕可用宽：" + cfg.screenWidthDp + "\n");
        status.append("系统触摸屏幕的触摸方式：" + cfg.touchscreen + "\n");
        status.append("screenLayout:" + cfg.screenLayout + "\n");
        status.append("smallestScreenWidthDp:" + cfg.smallestScreenWidthDp + "\n");
        status.append("uiMode:" + cfg.uiMode + "\n");

        tvSystemConfiguration.setText(status);
    }

    /**
     * 监听系统配置的更改
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //更改后的屏幕方向
        int screen = newConfig.orientation;
        String ori = (Configuration.ORIENTATION_LANDSCAPE == screen ? "横屏" : "竖屏");

        Toast.makeText(this, "系统屏幕方向更改为：" + ori, Toast.LENGTH_SHORT).show();
    }
}
