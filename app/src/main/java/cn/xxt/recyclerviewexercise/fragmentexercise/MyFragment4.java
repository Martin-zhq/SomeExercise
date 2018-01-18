package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2018/1/18.
 */

public class MyFragment4 extends Fragment {
    /** name 字段需要在onSaveInstanceState方法中保存 */
    public String name = "name: default";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("name", name);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            //恢复name字段值
            String s = savedInstanceState.getString("name");
            if (s != null) {
                name = s;
            }
        }
        super.onActivityCreated(savedInstanceState);
    }

    //onInflate()方法会在MyFragment与窗口类绑定之前调用，所以可以在该方法中调用setArguments方法设置Bundle对象，并设置
    //name参数的默认值


    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        if (getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", "arg:default");
            //设置bundle对象
            setArguments(bundle);
        }
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment4, container, false);
        return view;
    }
}
