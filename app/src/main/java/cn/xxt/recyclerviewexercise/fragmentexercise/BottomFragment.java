package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2018/1/18.
 */

public class BottomFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment, container, false);
        return view;
    }

    public void updateText(String value) {
        EditText editText = (EditText)getView();
        editText.setText(value);
    }
}
