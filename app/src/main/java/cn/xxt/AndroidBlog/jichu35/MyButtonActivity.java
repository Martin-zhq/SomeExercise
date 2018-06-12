package cn.xxt.AndroidBlog.jichu35;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;

public class MyButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_button);

        MyButton myButton = findViewById(R.id.mybutton);
        //绑定监听事件
        myButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MyButtonActivity.this, "activity收到事件监听"
                        , Toast.LENGTH_SHORT).show();
                //return false，表明该事件会继续向外扩散
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Toast.makeText(this, "activity回调onTouchEvent方法", Toast.LENGTH_SHORT).show();
        return false;
    }
}
