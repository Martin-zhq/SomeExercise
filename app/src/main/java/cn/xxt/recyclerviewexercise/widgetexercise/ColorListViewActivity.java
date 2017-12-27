package cn.xxt.recyclerviewexercise.widgetexercise;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import cn.xxt.recyclerviewexercise.R;
/**
 * 改变listView的背景颜色
 * @author zhq
 * @date 2017/12/27 下午2:11
 */
public class ColorListViewActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView lvColor;

    private RadioButton rbDefault;

    private RadioButton rbGreen;

    private RadioButton rbYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_list_view);

        lvColor = findViewById(R.id.lv_color);
        rbDefault = findViewById(R.id.rb_default);
        rbGreen = findViewById(R.id.rb_green);
        rbYellow = findViewById(R.id.rb_yellow);

        String [] data = new String[] {"凯特琳", "维恩", "崔丝塔娜", "维鲁斯", "卢锡安", "烬", "金克斯"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lvColor.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_default:
                break;
            case R.id.rb_green:
                Drawable drawable = getResources().getDrawable(R.drawable.green);
                lvColor.setSelector(drawable);
                break;
            case R.id.rb_yellow:
                Drawable drawable1 = getResources().getDrawable(R.drawable.yellow);
                lvColor.setSelector(drawable1);
                break;
            default:
        }
    }
}
