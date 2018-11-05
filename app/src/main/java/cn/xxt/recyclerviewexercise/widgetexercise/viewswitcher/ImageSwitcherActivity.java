package cn.xxt.recyclerviewexercise.widgetexercise.viewswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import cn.xxt.recyclerviewexercise.R;
/**
 * imageSwitcher
 * @author zhq
 * @date 2018/11/5 下午3:23
 */
public class ImageSwitcherActivity extends AppCompatActivity implements ImageSwitcher.ViewFactory{

    private int[] imgIds = {
       R.drawable.face1, R.drawable.face2, R.drawable.face3, R.drawable.face4
    } ;

    private int index;

    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        imageSwitcher = findViewById(R.id.img_switcher);
        imageSwitcher.setFactory(this);

        //初始化
        imageSwitcher.setImageResource(imgIds[0]);

        imageSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if (index >= imgIds.length) {
                    index = 0;
                }
                imageSwitcher.setImageResource(imgIds[index]);
            }
        });
    }


    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(0xFF000000);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }
}
