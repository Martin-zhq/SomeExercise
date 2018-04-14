package cn.xxt.AndroidBlog.jichu21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/4/14 上午9:57
 */
public class ToggleActivity extends AppCompatActivity {

    private ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);

        tb = findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ToggleActivity.this, buttonView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
