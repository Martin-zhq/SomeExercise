package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.xxt.recyclerviewexercise.R;

/**
 *
 * @author zhq
 * @date 2018/1/8 上午9:14
 */

public class UiFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        //从小设置了容器的大小
        container.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
        View view = inflater.inflate(R.layout.ui_fragment, container, false);
        return view;
    }
}
