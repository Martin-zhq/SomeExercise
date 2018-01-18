package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/1/18 下午7:09
 */
public class FragmentCallbackActivity extends AppCompatActivity implements TopFragment.OnTopButtonClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frament_callback);
    }

    @Override
    public void onClick(String name) {
        //通过tag获取BottomFragment对象
        BottomFragment fragment = (BottomFragment) getFragmentManager().findFragmentByTag("bottom_fragment");
        fragment.updateText("onClick:" + name);
    }
}
