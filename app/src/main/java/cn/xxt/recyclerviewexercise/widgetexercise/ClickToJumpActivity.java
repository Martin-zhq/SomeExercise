package cn.xxt.recyclerviewexercise.widgetexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/22 下午4:18
 */
public class ClickToJumpActivity extends AppCompatActivity {

    private TextView tvJump1;

    private TextView tvJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_to_jump);

        tvJump1 = findViewById(R.id.tv_jump1);
        tvJump2 = findViewById(R.id.tv_jump2);

        String text1 = "跳转到TextViewExerciseActivity";
        String text2 = "跳转到TextViewImgActivity";

        SpannableString spannableString1 = new SpannableString(text1);
        SpannableString spannableString2 = new SpannableString(text2);
        //将text1中的所有文本设置成ClickableSpan对象，并实现了onClick方法
        spannableString1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(ClickToJumpActivity.this, TextViewExerciseActivity.class);
                startActivity(intent);
            }
        }, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //将text2中的所有文本设置成ClickableSpan对象，并实现了onClick方法
        spannableString2.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(ClickToJumpActivity.this, TextViewImgActivity.class);
                startActivity(intent);
            }
        }, 0, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //将SpannableString对象设置到两个TextView上
        tvJump1.setText(spannableString1);
        tvJump2.setText(spannableString2);

        tvJump1.setMovementMethod(LinkMovementMethod.getInstance());
        tvJump2.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
