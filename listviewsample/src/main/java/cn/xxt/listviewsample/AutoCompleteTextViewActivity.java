package cn.xxt.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

/**
 * 自动填充输入框
 * @author zhq
 * @date 2018/6/26 下午7:30
 */
public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private AutoCompleteTextView actv;

    private MultiAutoCompleteTextView mactv;

    /** 字符串数组，作为提示的文本 */
    private String[] contacts = new String[] {
            "test", "abc", "aaa", "aabbcc", "bac", "ok", "say", "aabbsd", "sisl"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        actv = findViewById(R.id.actv);
        mactv = findViewById(R.id.mactv);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, contacts);

        actv.setAdapter(adapter);
        mactv.setAdapter(adapter);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
