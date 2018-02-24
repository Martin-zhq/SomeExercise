package cn.xxt.recyclerviewexercise.switchtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;

/**
 * 开关
 * @author zhq
 * @date 2018/2/22 下午4:25
 */
public class SwitchTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_test);

        final Switch aSwitch = findViewById(R.id.s_v);
        aSwitch.setChecked(false);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //开关打开或关闭
                if (b) {
                    Toast.makeText(SwitchTestActivity.this, "开关打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SwitchTestActivity.this, "开关关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
