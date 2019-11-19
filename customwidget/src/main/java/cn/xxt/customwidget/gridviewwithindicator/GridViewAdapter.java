package cn.xxt.customwidget.gridviewwithindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.customwidget.R;

/**
 * 网格菜单中GridView适配器
 * @author zhq
 * @date 2019-07-24 11:10
 */
class GridViewAdapter extends BaseAdapter {

    private Context context;

    /** 当前GridView所处页码 */
    private int currentPage;

    /** 每一页中GridView要显示的数量 */
    private int perPageNum;

    private List<DataBean> dataList = new ArrayList<>();

    private OnGridViewAdapterListener onGridViewAdapterListener;

    /**
     * @param context
     * @param datas 总的数据源
     * @param currentPage 当前GridView所处页码
     * @param perPageNum 每一页中GridView要显示的数量
     */
    GridViewAdapter(Context context, List<DataBean> datas, int currentPage, int perPageNum) {
        this.context = context;
        this.currentPage = currentPage;
        this.perPageNum = perPageNum;
        //start end分别代表要显示的数组在总数据List中的开始和结束位置
        int start = currentPage * perPageNum;
        int end = start + perPageNum;
        while ((start < datas.size()) && (start < end)) {
            dataList.add(datas.get(start));
            start++;
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        ViewHolder mHolder;
        final int pos = i;
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gridview, viewGroup, false);
            mHolder.rlRoot = itemView.findViewById(R.id.rl_root);
            mHolder.iv_img = (ImageView) itemView.findViewById(R.id.iv_bg);
            mHolder.tv_text = (TextView) itemView.findViewById(R.id.tv_name);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        final DataBean bean = dataList.get(i);
        if (bean != null) {
            mHolder.iv_img.setImageResource(R.drawable.group_icon);
            mHolder.tv_text.setText(bean.name);
            mHolder.rlRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != onGridViewAdapterListener) {
                        onGridViewAdapterListener.clickItem(bean);
                    }
                }
            });
        }
        return itemView;
    }

    private class ViewHolder {
        private RelativeLayout rlRoot;
        private ImageView iv_img;
        private TextView tv_text;
    }

    public interface OnGridViewAdapterListener {
        // TODO: 2019-07-24 待调整
        void clickItem(DataBean dataBean);
    }

    public void setOnGridViewAdapterListener(OnGridViewAdapterListener onGridViewAdapterListener) {
        this.onGridViewAdapterListener = onGridViewAdapterListener;
    }
}
