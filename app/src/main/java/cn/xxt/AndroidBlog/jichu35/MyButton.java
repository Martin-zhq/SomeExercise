package cn.xxt.AndroidBlog.jichu35;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;

public class MyButton extends AppCompatButton {

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Toast.makeText(getContext(), "MyButton回调onTouchEVent方法", Toast.LENGTH_SHORT).show();
        //返回true，表明该事件不会向外扩散
        //返回false，表明事件会向外扩散
        return false;
    }
}
