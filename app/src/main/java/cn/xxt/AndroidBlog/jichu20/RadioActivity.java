package cn.xxt.AndroidBlog.jichu20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/4/14 上午9:44
 */
public class RadioActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton rbMan;
    private RadioButton rbWoman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        radioGroup = findViewById(R.id.rg);
        rbMan = findViewById(R.id.rb_man);
        rbWoman = findViewById(R.id.rb_woman);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String text = "";
                if (R.id.rg == group.getId()) {
                    switch (checkedId) {
                        case R.id.rb_man:
                            text = rbMan.getText().toString();
                            break;
                        case R.id.rb_woman:
                            text = rbWoman.getText().toString();
                            break;
                        default:
                            break;
                    }
                }
                Toast.makeText(RadioActivity.this, "你选择了：" + text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
