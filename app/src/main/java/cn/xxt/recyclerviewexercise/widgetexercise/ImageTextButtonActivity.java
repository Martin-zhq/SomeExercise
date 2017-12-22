package cn.xxt.recyclerviewexercise.widgetexercise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.widget.Button;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/22 下午7:33
 */
public class ImageTextButtonActivity extends AppCompatActivity {

    private Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_text_button);
        btn5 = findViewById(R.id.btn5);
        //处理文字左侧的图像
        SpannableString spannableString1 = new SpannableString("left");
        Bitmap leftBmp = BitmapFactory.decodeResource(getResources(), R.drawable.face4);
        ImageSpan imageSpanLeft = new ImageSpan(leftBmp, DynamicDrawableSpan.ALIGN_BOTTOM);
        //将left替换成imageSpanLeft
        spannableString1.setSpan(imageSpanLeft, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //处理文字右侧的图像
        SpannableString spannableString2 = new SpannableString("right");
        Bitmap rightBmp = BitmapFactory.decodeResource(getResources(), R.drawable.face5);
        ImageSpan imageSpanRight = new ImageSpan(rightBmp, DynamicDrawableSpan.ALIGN_BOTTOM);
        //将right替换成imageSpanRight
        spannableString2.setSpan(imageSpanRight, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        btn5.append(spannableString1);
        btn5.append("这是我的按钮5");
        btn5.append(spannableString2);
    }
}
