package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;

public class BaseRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.rv_comment_list);
        recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        List<Model> list = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            Model model = new Model();
            model.setTest("哈哈哈，影分身：" + i);
            list.add(model);
        }
        MyBaseRecyclerViewAdapter adapter = new MyBaseRecyclerViewAdapter(R.layout.item_base_recyclerview_adapter, list);

        recyclerView.setAdapter(adapter);
    }
}
