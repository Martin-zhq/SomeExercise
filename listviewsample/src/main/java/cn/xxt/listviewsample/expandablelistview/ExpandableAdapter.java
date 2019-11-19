package cn.xxt.listviewsample.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import cn.xxt.listviewsample.R;

/**
 * @Author zhq
 * @Date 2019-06-25-11:35
 * @Description
 * @Email 1457453696@qq.com
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<GroupBean> groups;
    private List<List<ChildBean>> childs;

    public ExpandableAdapter(Context context, List<GroupBean> groups, List<List<ChildBean>> childs) {
        this.context = context;
        this.groups = groups;
        this.childs = childs;
    }

    @Override
    public int getGroupCount() {
        return null != groups ? groups.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (null != childs && null != childs.get(groupPosition)) {
            return childs.get(groupPosition).size();
        }

        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        if (null != groups) {
            return groups.get(groupPosition);
        }
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (null != childs) {
            return childs.get(groupPosition).get(childPosition);
        }
        return null;
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
        GroupViewHolder groupViewHolder;
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(R.layout.group_item_layout, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvGroupName = convertView.findViewById(R.id.tv_group_name);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvGroupName.setText(groups.get(groupPosition).getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(R.layout.child_item_layout, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvChildName = convertView.findViewById(R.id.tv_child_name);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.tvChildName.setText(childs.get(groupPosition).get(childPosition).getName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class GroupViewHolder {
        TextView tvGroupName;
    }

    static class ChildViewHolder {
        TextView tvChildName;
    }
}

