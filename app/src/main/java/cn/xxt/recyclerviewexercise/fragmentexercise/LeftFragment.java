package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;

import cn.xxt.recyclerviewexercise.R;

/**
 * fragment练习
 * @author zhq
 * @date 2018/1/6 下午3:20
 */

public class LeftFragment extends Fragment implements AdapterView.OnItemClickListener{

    private String[] data = new String[] { "妖铃铃", "芳华", "Coco"};

    private ListView listView;

    /**
     * 该方法返回的view会显示在fragment中
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //装载Fragment的布局文件，并返回布局文件根节点对应的view
        View view = inflater.inflate(R.layout.left_fragment, null);
        listView = view.findViewById(R.id.lv_movie);
        listView.setOnItemClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, data);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            TextView textView = (TextView)getActivity().findViewById(R.id.tv_detail);
            //assets 目录    返回指向asset是目录中的m0,m1,m2文件中数据的InputStream对象
            InputStream is = getActivity().getResources().getAssets().open("m" + position);
            byte[] buffer = new byte[1024];
            //每次最多从文件中读取1024个字节
            int count = is.read(buffer);
            //将读出的自己按utf-8的格式转换为字符串
            String detail = new String(buffer, 0, count, "utf-8");
            if (textView == null) {
                //表示当前为手机屏幕
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("detail", detail);
                startActivity(intent);
            } else {
                //平板电脑
                textView.setText(detail);
            }
            is.close();
        } catch (Exception e) {

        }
    }
}
