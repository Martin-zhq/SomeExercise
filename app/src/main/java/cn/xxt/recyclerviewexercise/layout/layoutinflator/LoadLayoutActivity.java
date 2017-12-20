package cn.xxt.recyclerviewexercise.layout.layoutinflator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/20 上午11:05
 */
public class LoadLayoutActivity extends AppCompatActivity {

    private TextView tvBeauty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_layout);

        //装载主窗口使用的布局
        LinearLayout parent = (LinearLayout)getLayoutInflater().inflate(R.layout.activity_load_layout, null);
        //循环装载item.xml
        for (int i = 0; i < 10; i++) {
            //因为view是动态添加的，所以inflate方法的第二个参数为null。
            View view = getLayoutInflater().inflate(R.layout.item, null);
            tvBeauty = view.findViewById(R.id.tv_beauty);
            tvBeauty.setText("Beauty" + i);
            //动态设置布局属性   通过layoutParams对象
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            //设置gravity字段
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
            //动态添加视图时，指定父视图的布局参数
            parent.addView(view, layoutParams);
//            parent.addView(view);
        }
        setContentView(parent);
    }
}
