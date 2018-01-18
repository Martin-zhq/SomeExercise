package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xxt.recyclerviewexercise.R;

/**
 *
 * @author zhq
 * @date 2018/1/8 上午10:18
 */

public class MyFragment3 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment3, null);
        return view;
    }

    @Override
    public void onDestroyView() {
        Log.d("name", getArguments().getString("name"));
        super.onDestroyView();
    }
}
