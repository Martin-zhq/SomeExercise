package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/1/8 上午9:17
 */
public class RuntimeCreateFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_create_fragment);
    }

    public void clickBtnCreateUiFragment(View view) {
        //获取FragmentManager对象
        FragmentManager manager = getFragmentManager();
        //开始Fragment事务
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        UiFragment fragment = new UiFragment();
        fragmentTransaction.add(R.id.frame_container, fragment);
        //提交事务
        fragmentTransaction.commit();
    }
}
