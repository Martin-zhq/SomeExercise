package cn.xxt.recyclerviewexercise.saveinstance;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/19 下午2:21
 */
public class SaveStateActivity extends AppCompatActivity {

    private TextView tvState;

    /** 定义value变量并设置默认值 */
    private String value = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_state);

        if (savedInstanceState != null) {
            value = savedInstanceState.getString("value");
        }
        tvState = findViewById(R.id.tv_state);
    }

    public void clickBtnSetValue(View view) {
        value = "newValue";
    }

    public void clickBtnOutputValue(View view) {
        tvState.setText(value);
        Log.d("value", value);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("value", value);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
