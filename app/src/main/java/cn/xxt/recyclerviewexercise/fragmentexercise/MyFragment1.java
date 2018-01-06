package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xxt.recyclerviewexercise.R;

/**
 *
 * @author zhq
 * @date 2018/1/6 下午4:21
 */

public class MyFragment1 extends Fragment {

    private static final String TAG = "MyFragment1";

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {

        Log.d(TAG, "onInflate方法");
        //输出字符串资源
        Log.d("Fragment1_stringRes", activity.getResources().getString(R.string.app_name));
        //输出<fragment>标签的class属性值
        Log.d("Fragment1_class", attrs.getAttributeValue(null, "class"));
        //无法获取与Fragment关联的对象,输出null
        Log.d("Fragment1_getActivity", String.valueOf(getActivity()));
        //无法获取EditText对象,输出null
        Log.d("Fragment1_edittext1", String.valueOf(activity.findViewById(R.id.edittext1)));
        //未保存Fragment的状态，输出为null
        Log.d("Fragment1_savedInstance", String.valueOf(savedInstanceState));

        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "onAttach方法");
        //无法获取EditText对象输出null
        Log.d("Fragment1_edittext1", String.valueOf(activity.findViewById(R.id.edittext1)));
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate方法");
        //可以获取与Fragment关联的窗口对象
        Log.d("Fragment_getActivity", String.valueOf(getActivity()));
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView方法");
        View view = inflater.inflate(R.layout.my_fragment1, null);
        //无法获取，输出null
        Log.d("Fragment1_getActivity", String.valueOf(getActivity().findViewById(R.id.edittext1)));
        Log.d("Fragment1_view", String.valueOf(view.findViewById(R.id.edittext1)));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated方法");
        //无法获取，输出null
        Log.d("Fragment1_getActivity", String.valueOf(getActivity().findViewById(R.id.edittext1)));
        //可以获取
        Log.d("Fragment1_view", String.valueOf(view.findViewById(R.id.edittext1)));
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated方法");
        //可以通过getActivity方法获取EditText对象
        Log.d("Fragment_getActivity", String.valueOf(getActivity().findViewById(R.id.edittext1)));
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart方法");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume方法");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause方法");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop方法");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView方法");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy方法");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach方法");
        super.onDetach();
    }
}

