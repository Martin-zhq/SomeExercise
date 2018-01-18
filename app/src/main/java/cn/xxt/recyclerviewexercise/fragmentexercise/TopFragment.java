package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xxt.recyclerviewexercise.R;

/**
 * Created by zhq on 2018/1/18.
 */

public class TopFragment extends Fragment implements View.OnClickListener{

    private OnTopButtonClickedListener listener;

    /**
     * 提供回调方法的接口，通常嵌入此Fragment的类会实现此接口
     */
    public interface OnTopButtonClickedListener {
        public void onClick(String name);
    }

    @Override
    public void onAttach(Activity activity) {
        if (getActivity() instanceof OnTopButtonClickedListener) {
            listener = (OnTopButtonClickedListener)getActivity();
        }
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment, null);
        view.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick("Top Fragment Demo");
        }
    }
}
