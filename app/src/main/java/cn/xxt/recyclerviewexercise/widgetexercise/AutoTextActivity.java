package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/22 下午5:44
 */
public class AutoTextActivity extends AppCompatActivity {

    private AutoCompleteTextView actv;

    private MultiAutoCompleteTextView mactv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_text);

        actv = findViewById(R.id.actv);
        mactv = findViewById(R.id.mactv);
        String[] autoString = new String[] {"联合国", "联合国理事会", "联合国秘书长",
        "联合国大使", "bb", "bcd", "bcdf", "Google", "Google Map", "Google Android"};

        //第2个参数为每一个列表项使用的视图资源id，第3个参数指定数组对象。
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
                autoString);
        actv.setAdapter(adapter);
        mactv.setAdapter(adapter);
        //输入多个字符串时的分隔符号为"，"
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
