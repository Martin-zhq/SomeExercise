package cn.xxt.customwidget.tablayouttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.xxt.customwidget.R;

/**
 * @Author zhq
 * @Date 2019-06-19-10:44
 * @Description
 * @Email 1457453696@qq.com
 */
public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView tvContent = view.findViewById(R.id.tv_content);
        tvContent.setText("Fragment_3");
        return view;
    }
}
