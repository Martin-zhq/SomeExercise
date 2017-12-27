package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.xxt.recyclerviewexercise.R;
/**
 * ListView列表项添加复选框和单选按钮
 * @author zhq
 * @date 2017/12/27 上午10:30
 */
public class ChoiceListViewActivity extends AppCompatActivity {

    private String[] data = new String[]{ "Android", "Kotlin", "Swift", "Objective-C"};

    private ListView lvCheckedTextView;

    private ListView lvRadioButton;

    private ListView lvCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_list_view);

        lvCheckedTextView = findViewById(R.id.lv_checked_textView);
        lvRadioButton = findViewById(R.id.lv_radio_button);
        lvCheckBox = findViewById(R.id.lv_checkbox);

        ArrayAdapter<String> checkedTextViewAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, data);
        lvCheckedTextView.setAdapter(checkedTextViewAdapter);
        //设置成单选模式
        lvCheckedTextView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> radioButtonAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, data);
        lvRadioButton.setAdapter(radioButtonAdapter);
        //单选
        lvRadioButton.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> checkboxAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data);
        lvCheckBox.setAdapter(checkboxAdapter);
        //多选
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
