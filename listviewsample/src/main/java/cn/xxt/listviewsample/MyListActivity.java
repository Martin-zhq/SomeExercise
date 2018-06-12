package cn.xxt.listviewsample;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

/**
 * listActiity简单使用
 * @author zhq
 * @date 2018/6/8 上午11:23
 */
public class MyListActivity extends ListActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String [] heros = {"掘墓", "巨魔", "菲奥娜", "瑞文", "贾克斯", "青钢影"
                , "克烈", "内瑟斯", "鳄鱼", "诺克"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_single_choice, heros);

        setListAdapter(adapter);
    }
}
