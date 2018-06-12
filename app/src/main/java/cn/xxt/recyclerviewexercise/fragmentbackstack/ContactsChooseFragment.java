package cn.xxt.recyclerviewexercise.fragmentbackstack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.xxt.recyclerviewexercise.R;

public class ContactsChooseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ttl_list_fragment, container, false);

        Button button = view.findViewById(R.id.btn_jump);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackStackActivity backStackActivity = (BackStackActivity)getActivity();
                backStackActivity.initUiWithData(null, BackStackActivity.SHOW_TTL_ASSIGN);
            }
        });
        return view;
    }
}
