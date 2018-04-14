package cn.xxt.AndroidBlog.jichu20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/4/14 上午9:24
 */
public class CheckActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private CheckBox cbBo;
    private CheckBox cbCang;
    private CheckBox cbJia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        cbBo = findViewById(R.id.cb_bo);
        cbCang = findViewById(R.id.cb_cang);
        cbJia = findViewById(R.id.cb_jia);

        cbBo.setOnCheckedChangeListener(this);
        cbCang.setOnCheckedChangeListener(this);
        cbJia.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb_bo:
                showYourChoose(buttonView);
                break;
            case R.id.cb_cang:
                showYourChoose(buttonView);
                break;
            case R.id.cb_jia:
                showYourChoose(buttonView);
                break;
            default:
                break;
        }
    }

    private void showYourChoose(CompoundButton compoundButton) {
        if (compoundButton.isChecked()) {
            Toast.makeText(this, "你选择了：" + compoundButton.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "你取消了选择：" + compoundButton.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
