package cn.xxt.listviewsample.expandablelistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.listviewsample.R;
/**
 *
 * @author zhq
 * @date 2019-06-25 14:35
 */
public class ExpandableListViewTestActivity extends AppCompatActivity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view_test);

        context = this;

        ExpandableListView expandableListView = findViewById(R.id.expandable_lv);
        List<GroupBean> groups = new ArrayList<>();
        for (int i = 0; i < 3; i ++) {
            groups.add(new GroupBean("group " + i));
        }

        List<List<ChildBean>> childs = new ArrayList<>();
        for (int i = 0; i < 3; i ++) {
            List<ChildBean> childBeans = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                childBeans.add(new ChildBean("child " + i + "-" + j));
            }
            childs.add(childBeans);
        }

        ExpandableAdapter expandableAdapter = new ExpandableAdapter(this, groups, childs);

        expandableListView.setAdapter(expandableAdapter);
        for (int i = 0; i < expandableAdapter.getGroupCount(); i++) {
            expandableListView.expandGroup(i);
        }
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(context, "点击" + groupPosition + "-" + childPosition
                        , Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
