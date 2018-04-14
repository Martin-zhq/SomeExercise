package cn.xxt.AndroidBlog.jichu16;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CodeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("大吉大利，今晚吃鸡");

        linearLayout.addView(tv);

        setContentView(linearLayout);
    }
}
