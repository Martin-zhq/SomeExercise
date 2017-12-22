package cn.xxt.recyclerviewexercise.widgetexercise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.util.Random;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/22 下午5:04
 */
public class EditFaceActivity extends AppCompatActivity {

    EditText etFaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_face);
        etFaces = findViewById(R.id.et_faces);
    }

    public void clickBtnRandomInsert(View view) {
        int randomId = 1 + new Random().nextInt(8);
        try {
            //从R.drawable中获得相应资源ID的field对象
            Field field = R.drawable.class.getDeclaredField("face" + randomId);
            //获得资源id的值，也就是静态变量的值
            int resourceId = Integer.parseInt(field.get(null).toString());
            //根据资源id获取资源图像的Bitmap对象
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
            //根据bitmap对象，创建ImgSpan对象
            ImageSpan imageSpan = new ImageSpan(this, bitmap);
            //创建一个SpannableString对象，以便插入用ImageSpan对象封装的图像
            SpannableString spannableString = new SpannableString("face");
            //用ImagSpan对象替换face
            spannableString.setSpan(imageSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //将随机获得图像追加到EditText控件的最后
            etFaces.append(spannableString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
