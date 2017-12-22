package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2017/12/22 下午6:23
 */
public class ButtonExerciseActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener
,View.OnFocusChangeListener, View.OnKeyListener{

    private int value = 1;

    private Button btn1;

    private Button btn2;

    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnTouchListener(this);
        btn3.setOnKeyListener(this);
        btn3.setOnFocusChangeListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
            case R.id.btn2:
                Button button = (Button)v;
                //缩小
                if (value == 1 && button.getWidth()==getWindowManager().getDefaultDisplay().getWidth()) {
                    value = -1;
                }else if (value == -1 && button.getWidth() < 100) {
                    //按钮宽度小于100时，则放大
                    value = 1;
                }
                //已按钮宽高的10%放大或缩小
                button.setWidth(button.getWidth() + (int)(button.getWidth() * 0.1) * value);
                button.setHeight(button.getHeight() + (int)(button.getHeight() * 0.1) * value);
                break;

            default:
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.btn3) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                //当手指抬起时恢复默认状态
                v.setBackgroundResource(R.drawable.moren);
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.setBackgroundResource(R.drawable.anxia);
            }
        }
        return false;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == R.id.btn3) {
            if (hasFocus) {
                v.setBackgroundResource(R.drawable.anxia);
            } else {
                v.setBackgroundResource(R.drawable.moren);
            }
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (v.getId() == R.id.btn3) {
            if (KeyEvent.ACTION_DOWN == event.getAction()) {
                v.setBackgroundResource(R.drawable.anxia);
            } else if (KeyEvent.ACTION_UP == event.getAction()) {
                v.setBackgroundResource(R.drawable.moren);
            }
        }
        return false;
    }
}
