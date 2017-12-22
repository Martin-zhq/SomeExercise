package cn.xxt.recyclerviewexercise.widgetexercise;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/22 下午4:40
 */
public class TextBackGroundActivity extends AppCompatActivity {

    private TextView tv1;

    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_back_ground);

        tv1 = findViewById(R.id.tv1);
        String text1 = "<没有背景><黄色背景>";
        //1、将字符串转换成SpannableString对象
        SpannableString spannableString1 = new SpannableString(text1);
        //2、确定要设置的字符串的start和end
        int start = 6;
        int end = 12;
        //3、创建backgroundColorSpan对象
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.YELLOW);
        //4、使用setSpan方法将指定字符串转换成BackgroundColorSpan对象
        spannableString1.setSpan(backgroundColorSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //5、用SpannableString对象设置tv1
        tv1.setText(spannableString1);

        tv2 = findViewById(R.id.tv2);
        //tv2中的字符串
        String text2 = "<没有背景><黄色背景>\n\n<蓝色背景，红色文字>";
        SpannableString spannableString2 = new SpannableString(text2);
        int start2 = 6;
        int end2 = 12;
        BackgroundColorSpan b2 = new BackgroundColorSpan(Color.YELLOW);
        spannableString2.setSpan(b2, start2, end2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        start2 = 14;
        ColorSpan span = new ColorSpan(Color.RED, Color.BLUE);
        spannableString2.setSpan(span, start2, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv2.setText(spannableString2);
    }
}
