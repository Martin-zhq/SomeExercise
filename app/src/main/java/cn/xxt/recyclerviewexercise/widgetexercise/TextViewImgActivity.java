package cn.xxt.recyclerviewexercise.widgetexercise;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import java.lang.reflect.Field;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/22 下午3:56
 */
public class TextViewImgActivity extends AppCompatActivity {

    private TextView tvImgTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_img);

        tvImgTest = findViewById(R.id.tv_img_test);
        tvImgTest.setTextColor(Color.BLACK);
        tvImgTest.setBackgroundColor(Color.WHITE);
        tvImgTest.setTextSize(20);
        //定义并初始化一个带img标签的字符串
        String html = "图像1<img src='face1'/>图像2<img src='face2'/>图像3<img src='face3'/><p>";
        html += "图像4<a hre='http://www.baidu.com'><img src='face4'/></a>图像5<img src='face5'/>图像6<img src='face6'/>";
        //调用Html.fromHtml方法处理<img>标签，将src属性值转换为图像（Drawable图像）
        CharSequence charSequence = Html.fromHtml(html, new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                Drawable drawable = getResources().getDrawable(getResourceId(source));
                //第三个图像压缩50%
                if ("face3".equals(source)) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth()/2, drawable.getIntrinsicHeight()/2);
                } else {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
                return drawable;
            }
        }, null);

        tvImgTest.setText(charSequence);
        //使用a标签就得调用这个方法，否则a标签不起作用
        tvImgTest.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private int getResourceId(String name) {
        try {
            //根据资源ID，获得Field的对象
            Field field = R.drawable.class.getField(name);
            return Integer.parseInt(field.get(null).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
