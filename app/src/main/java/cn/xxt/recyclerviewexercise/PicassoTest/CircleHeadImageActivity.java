package cn.xxt.recyclerviewexercise.PicassoTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;
import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class CircleHeadImageActivity extends AppCompatActivity {
    private List<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_head_image);
        ImageView ivCircleHead1 = findViewById(R.id.iv1);
        ImageView ivCircleHead2 = findViewById(R.id.iv2);
        ImageView ivCircleHead3 = findViewById(R.id.iv3);
        ImageView ivCircleHead4 = findViewById(R.id.iv4);
        ImageView ivCircleHead5 = findViewById(R.id.iv5);
        ImageView ivCircleHead6 = findViewById(R.id.iv6);
        ImageView ivCircleHead7 = findViewById(R.id.iv7);
//        Picasso.with(this)
//                .load("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg")
//                .transform(new CropCircleTransformation())
//                .into(ivCircleHead);
        Picasso.with(this)
                .setIndicatorsEnabled(true);
        Picasso.with(this)
                .load("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
                .placeholder(R.drawable.face1)
                .error(R.drawable.face3)
                .transform(new CropCircleTransformation())
                .into(ivCircleHead1);
//        Picasso.with(this)
//                .load("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
//                .placeholder(R.drawable.face1)
//                .error(R.drawable.face3)
//                .transform(new MaskTransformation(this, 1))
//                .into(ivCircleHead2);
        Picasso.with(this)
                .load("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
                .placeholder(R.drawable.face1)
                .error(R.drawable.face3)
                .transform(new BlurTransformation(this))
                .into(ivCircleHead3);
        Picasso.with(this)
                .load("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
                .placeholder(R.drawable.face1)
                .error(R.drawable.face3)
                .transform(new GrayscaleTransformation())
                .into(ivCircleHead4);
        Picasso.with(this)
                .load("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
                .placeholder(R.drawable.face1)
                .error(R.drawable.face3)
                .transform(new RoundedCornersTransformation(5, 10))
                .into(ivCircleHead5);
        Picasso.with(this)
                .load("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
                .placeholder(R.drawable.face1)
                .error(R.drawable.face3)
                .transform(new CropTransformation(50, 100, 50, 50))
                .into(ivCircleHead6);

        urls.add("http://f.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e97f760d908d7912396dd8c9c.jpg");
        urls.add("http://g.hiphotos.baidu.com/image/pic/item/4b90f603738da977c76ab6fab451f8198718e39e.jpg");
        urls.add("http://e.hiphotos.baidu.com/image/pic/item/902397dda144ad343de8b756d4a20cf430ad858f.jpg");
        urls.add("http://a.hiphotos.baidu.com/image/pic/item/a6efce1b9d16fdfa0fbc1ebfb68f8c5495ee7b8b.jpg");
        urls.add("http://b.hiphotos.baidu.com/image/pic/item/a71ea8d3fd1f4134e61e0f90211f95cad1c85e36.jpg");
        urls.add("http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e939011b9c86d07fec54e737d19645.jpg");
        urls.add("http://pica.nipic.com/2007-10-17/20071017111345564_2.jpg");
        urls.add("http://pic4.nipic.com/20091101/3672704_160309066949_2.jpg");
        urls.add("http://pic31.nipic.com/20130624/8821914_104949466000_2.jpg");

    }



}
