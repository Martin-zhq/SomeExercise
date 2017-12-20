package cn.xxt.recyclerviewexercise.layout.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;

/**
 *
 * @author zhq
 * @time 2017/12/20 上午9:29
 */
public class LinearLayoutTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_test);
    }

   public void clickBtn1(View view) {
       Intent intent = new Intent(this, LinearLayoutTest2Activity.class);
       startActivity(intent);
   }
}
