package cn.xxt.recyclerviewexercise.widgetexercise.viewswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;
/**
 * 可以实现类似手机屏幕应用图标的效果
 * @author zhq
 * @date 2018/11/5 上午11:38
 */
public class ViewSwitcherActivity extends AppCompatActivity implements View.OnClickListener{

    /** 定义一个常量，表示每屏显示的应用程序数 */
    public static final int NUMBER_PER_SCREEN = 12;
    /** 记录当前正在显示第几屏的程序 */
    public static int screenNo = -1;
    /** 总屏数 */
    public static int screenCount;

    private ViewSwitcher viewSwitcher;

    private Button btnPrevious;

    private Button btnNext;

    private ViewSwitcherBaseAdapter adapter;

    private List<ViewSwitcherItemData> itemDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher);

        viewSwitcher = findViewById(R.id.view_switcher);
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);

        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return ViewSwitcherActivity.this.getLayoutInflater().inflate(R.layout.slide_gridview,
                        null);
            }
        });

        for (int i = 0; i < 40; i++) {
            ViewSwitcherItemData item = new ViewSwitcherItemData("item" + i, R.mipmap.ic_launcher);
            itemDatas.add(item);
        }

        screenCount = itemDatas.size() % NUMBER_PER_SCREEN == 0 ?
                itemDatas.size() / NUMBER_PER_SCREEN :
                itemDatas.size() / NUMBER_PER_SCREEN + 1;

        adapter = new ViewSwitcherBaseAdapter(this, itemDatas);

        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        next();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_previous:
                previous();
                break;
            case R.id.btn_next:
                next();
                break;
            default:
        }
    }

    private void previous() {
        if (screenNo > 0) {
            screenNo--;

            viewSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
            viewSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);

            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showPrevious();
        }
    }

    private void next() {
        if (screenNo < screenCount - 1) {
            screenNo++;

            viewSwitcher.setInAnimation(this, android.R.anim.slide_out_right);
            viewSwitcher.setOutAnimation(this, android.R.anim.slide_in_left);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }
}
