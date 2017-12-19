package cn.xxt.recyclerviewexercise.configchanges;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class ConfigChangesActivity extends AppCompatActivity {

    //设置的变量的值
    private String name = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_changes);

        Log.d("invoked method", "onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("invoked method", "onDestroy");
    }

    public void clickBtnSettingVar(View view) {
        name = "android";
   }

    /**
     * 当通过activity的android:configChanges属性设置的配置发生变化时即会调用此方法
     * 本例中设置的是orientation和screenSize。
     * @param newConfig 变化后的新配置参数
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //屏幕变化后的方向
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("orientation", "landscape");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("orientation", "portrait");
        }
        //输出配置变化后的屏幕宽度
        Log.d("screen_width_dp", String.valueOf(newConfig.screenWidthDp));
        //高度
        Log.d("screen_height_dp", String.valueOf(newConfig.screenHeightDp));
        //配置变化后变量的值是否恢复默认值
        Log.d("name", name);
    }
}
