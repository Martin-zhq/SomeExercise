package cn.xxt.recyclerviewexercise.widgetexercise;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 可扩展的列表控件
 * @author zhq
 * @date 2017/12/27 下午3:22
 */
public class ExpandableListViewActivity extends ExpandableListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter();
        setListAdapter(adapter);
        registerForContextMenu(getExpandableListView());
    }

    public class MyExpandableListAdapter extends BaseExpandableListAdapter {

        private String[] provinces = {"河南", "山东", "江西", "四川"};

        private String[][] cities = {
                {"郑州", "新乡", "开封", "周口", "洛阳", "许昌"},
                {"济南", "青岛", "淄博", "枣庄"},
                {"南昌", "景德镇"},
                {"成都", "自贡", "攀枝花"}
        };

        @Override
        public int getGroupCount() {
            return provinces.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return cities[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return provinces[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return cities[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getGenericView();
            }
            TextView textView = (TextView)convertView;
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getGenericView();
            }
            TextView textView = (TextView) convertView;
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        /**
         * 返回用于显示列表项组中列表项的总数
         */
        public TextView getGenericView() {
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
            TextView textView = new TextView(ExpandableListViewActivity.this);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setPadding(36, 0 , 0, 0);
            textView.setTextSize(20);
            return textView;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo)menuInfo;
        //获得当前列表项的类型
        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        //获得当前列表项的文本
        String title = ((TextView)info.targetView).getText().toString();
        //单击子菜单时，弹出上下文菜单
        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD)
        {
            menu.setHeaderTitle("弹出菜单");
            menu.add(0, 0, 0, title);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo)item.getMenuInfo();
        String title = ((TextView)info.targetView).getText().toString();
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
        return true;
    }
}
