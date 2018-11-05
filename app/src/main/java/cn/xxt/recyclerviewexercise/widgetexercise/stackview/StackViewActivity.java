package cn.xxt.recyclerviewexercise.widgetexercise.stackview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.StackView;

import cn.xxt.recyclerviewexercise.R;
/**
 * 原生的叠加view ，qq空间的广告有类似效果
 * @author zhq
 * @date 2018/11/3 下午2:59
 */
public class StackViewActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] imagesId = {
            R.drawable.face1, R.drawable.face2, R.drawable.face3, R.drawable.face4,
            R.drawable.face5, R.drawable.face6, R.drawable.face7, R.drawable.face8
    };

    private StackView stackView;

    private Button btnPrevious;

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);

        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_previous:
                stackView.showPrevious();
                break;
            case R.id.btn_next:
                stackView.showNext();
                break;
            default:
        }
    }

    private void initView() {
        stackView = findViewById(R.id.stack_view);
        MyStackAdapter myStackAdapter = new MyStackAdapter(this, imagesId);
        stackView.setAdapter(myStackAdapter);

        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);

        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }
}
