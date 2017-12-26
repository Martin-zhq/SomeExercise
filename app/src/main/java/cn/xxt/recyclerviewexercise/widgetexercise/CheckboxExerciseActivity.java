package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/23 上午9:37
 */
public class CheckboxExerciseActivity extends AppCompatActivity implements View.OnClickListener{

    String[] checkboxText = new String[]{"是学生吗？", "是否喜欢android", "买车不？", "想挣钱不？", "买比特币不？"};
    List<CheckBox> checkBoxes = new ArrayList<>();
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_checkbox_exercise, null);
        for (int i = 0; i < checkboxText.length; i++) {
            //根据checkbox.xml文件创建CheckBox对象
            CheckBox checkBox = (CheckBox)getLayoutInflater().inflate(R.layout.checkbox, null);
            checkBox.setText(checkboxText[i]);
            checkBoxes.add(checkBox);
            linearLayout.addView(checkBox, i);
        }
        setContentView(linearLayout);
        btnConfirm = findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(this);

        //Gson 测试
        Gson gson = new Gson();
        Model model = new Model();
        model.setI(1);
        model.setStr("字符串");
        String result = gson.toJson(model);
        Log.d("test", result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
            String s = "";
            //扫描所有的CheckBox，以便获得被选中的复选框的文本
                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isChecked()) {
                        s += checkBox.getText() + "\n";
                    }
                }
                if ("".equals(s)) {
                    s = "你还没选呢！！！";
                }
                new AlertDialog.Builder(this).setMessage(s).setPositiveButton("关闭", null).show();
            break;
            default:
                break;
        }
    }
}
