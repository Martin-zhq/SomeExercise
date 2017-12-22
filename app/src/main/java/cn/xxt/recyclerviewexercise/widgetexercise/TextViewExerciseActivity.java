package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;
/**
 * 
 * @author zhq
 * @date 2017/12/22 下午3:25
 */
public class TextViewExerciseActivity extends AppCompatActivity {

    private TextView tvText1;

    private TextView tvText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_exercise);

        tvText1 = findViewById(R.id.tv_text1);
        tvText2 = findViewById(R.id.tv_text2);

        //TVText1显示的文本
        String html = "<font color='red'>I love Android~~~</font><br>";
        html += "<font color='#0000FF'><big><i>I love Android...</i></big></font><p>";
        html += "<font color='@"+android.R.color.white+"'><tt><b><big><u>I love Android.</u></big></b></tt></font><p>";
        html += "<big><a href='http://51happyblog.com'>我的网站：51happyblog.com</a></big>";

        //将带有预定义标签的字符串转换成CharSequence对象
        CharSequence charSequence = Html.fromHtml(html);
        //为第一个TextView控件设置要显示的文本
        tvText1.setText(charSequence);

        //tv2的文本
        String text = "我的URL:http://51happyblog.com\n";
        text += "我的Email:abcd@126.com\n";
        text += "我的电话：1008611";
        tvText2.setText(text);
        //单击链接跳转
        tvText2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
