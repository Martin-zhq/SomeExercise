package cn.xxt.AndroidBlog.jichu21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/4/14 下午2:20
 */
public class SwitchActivity extends AppCompatActivity {

    private Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(SwitchActivity.this, "打开蓝牙", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SwitchActivity.this, "关闭蓝牙", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
