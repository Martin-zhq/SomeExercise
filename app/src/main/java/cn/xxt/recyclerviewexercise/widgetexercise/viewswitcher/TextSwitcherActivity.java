package cn.xxt.recyclerviewexercise.widgetexercise.viewswitcher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import cn.xxt.recyclerviewexercise.R;
/**
 * textSwitcher
 * @author zhq
 * @date 2018/11/5 下午3:33
 */
public class TextSwitcherActivity extends AppCompatActivity {

    private String[] contents = {
            "你好", "HelloWorld", "good？", "boring", "shift"
    };

    private int currentIndex;

    private TextSwitcher textSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);

        textSwitcher = findViewById(R.id.text_switcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(TextSwitcherActivity.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });

        textSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSwitcher.setText(contents[++currentIndex % contents.length]);
            }
        });

        textSwitcher.setText(contents[0]);
    }
}
