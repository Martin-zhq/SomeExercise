package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 * toast练习
 * @author zhq
 * @date 2018/1/2 下午7:21
 */
public class ToastTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_test);
    }

    public void clickBtnMyToast(View view) {
        View view1 = getLayoutInflater().inflate(R.layout.toast_layout, null);
        TextView textView = view1.findViewById(R.id.tv_toast);
        textView.setText("贼困。。。好困哪。。。");
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view1);
        toast.show();
    }
}
