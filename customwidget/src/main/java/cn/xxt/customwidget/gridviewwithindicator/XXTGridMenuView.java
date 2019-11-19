package cn.xxt.customwidget.gridviewwithindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.customwidget.R;
import cn.xxt.customwidget.gridviewwithindicator.indicator.UIndicator;

/**
 * @Author zhq
 * @Date 2019-07-23-09:31
 * @Description 水平分页网格菜单，将指示器直接封装进去了，整体是ViewPager + GridView实现的
 * @Email 1457453696@qq.com
 */
public class XXTGridMenuView extends RelativeLayout implements GridViewAdapter.OnGridViewAdapterListener {

    private int defaultRootViewMarginLeft = 12;

    private int defaultRootViewMarginTop = 18;

    private int defaultRootViewElevation = 6;

    private int defaultViewPagerHeight = 84;

    private int defaultViewPagerMarginTop = 26;

    private int defaultIndicatorHeight = 6;

    private int defaultIndicatorMarginBottom = 15;

    private Drawable rootViewBackground;

    private int rootViewElevation;

    private int rootViewMarginLeft;

    private int rootViewMarginRight;

    private int rootViewMarginTop;

    private int rootViewMarginBottom;

    private int viewPagerHeight;

    private int viewPagerMarginTop;

    private int viewPagerMarginBottom;

    private int indicatorHeight;

    private int indicatorMarginBottom;

    private RelativeLayout rootView;

    private ViewPager viewPager;

    private UIndicator uIndicator;

    private List<DataBean> dataBeanList = new ArrayList<>();

    private List<GridView> gridList = new ArrayList<>();

    private Context context;

    private XXTGridMenuViewListener xxtGridMenuViewListener;

    public XXTGridMenuView(Context context) {
        super(context);
        this.context = context;
    }

    public XXTGridMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_xxt_grid_menu_view, this);
        init(attrs);
    }

    public XXTGridMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //获取控件，设置属性，绑定事件
        refreshUiWithData();
    }


    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.XXTGridMenuView
                , 0, 0);

        rootViewBackground = typedArray.getDrawable(R.styleable.XXTGridMenuView_root_view_background);
        if (null == rootViewBackground) {
            rootViewBackground = ContextCompat.getDrawable(context, R.drawable.bg_xxt_grid_menu_8_radius);
        }
        defaultRootViewElevation = DensityUtil.dip2px(context, defaultRootViewElevation);
        rootViewElevation = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_root_view_elevation
                , defaultRootViewElevation);
        defaultRootViewMarginLeft = DensityUtil.dip2px(context, defaultRootViewMarginLeft);
        rootViewMarginLeft = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_root_view_margin_left
                , defaultRootViewMarginLeft);
        rootViewMarginRight = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_root_view_margin_right
                , defaultRootViewMarginLeft);
        defaultRootViewMarginTop = DensityUtil.dip2px(context, defaultRootViewMarginTop);
        rootViewMarginTop = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_root_view_margin_top
                , defaultRootViewMarginTop);
        rootViewMarginBottom = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_root_view_margin_bottom
                , defaultRootViewMarginTop);

        defaultViewPagerHeight = DensityUtil.dip2px(context, defaultViewPagerHeight);
        viewPagerHeight = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_view_pager_height
                , defaultViewPagerHeight);
        defaultViewPagerMarginTop = DensityUtil.dip2px(context, defaultViewPagerMarginTop);
        viewPagerMarginTop = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_view_pager_margin_top
                , defaultViewPagerMarginTop);
        viewPagerMarginBottom = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_view_pager_margin_bottom
                , defaultViewPagerMarginTop);

        defaultIndicatorHeight = DensityUtil.dip2px(context, defaultIndicatorHeight);
        indicatorHeight = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_indicator_height
                , defaultIndicatorHeight);
        defaultIndicatorMarginBottom = DensityUtil.dip2px(context, defaultIndicatorMarginBottom);
        indicatorMarginBottom = (int)typedArray.getDimension(R.styleable.XXTGridMenuView_indicator_margin_bottom
                , defaultIndicatorMarginBottom);

        typedArray.recycle();
    }


    private void refreshUiWithData() {
        rootView = findViewById(R.id.card_view);
        viewPager = findViewById(R.id.view_pager);
        uIndicator = findViewById(R.id.indicator);

        rootView.setBackground(rootViewBackground);
        rootView.setElevation(rootViewElevation);
        RelativeLayout.LayoutParams rootViewLayoutParams = (RelativeLayout.LayoutParams)rootView.getLayoutParams();
        rootViewLayoutParams.setMargins(rootViewMarginLeft, rootViewMarginTop, rootViewMarginRight
                , rootViewMarginBottom);
        rootView.setLayoutParams(rootViewLayoutParams);

        RelativeLayout.LayoutParams viewPagerLayoutParams = (RelativeLayout.LayoutParams)viewPager.getLayoutParams();
        viewPagerLayoutParams.height = viewPagerHeight;
        viewPagerLayoutParams.setMargins(0, viewPagerMarginTop, 0, viewPagerMarginBottom);
        viewPager.setLayoutParams(viewPagerLayoutParams);

        RelativeLayout.LayoutParams indicatorLayoutParams = (RelativeLayout.LayoutParams)uIndicator.getLayoutParams();
        indicatorLayoutParams.height = indicatorHeight;
        indicatorLayoutParams.setMargins(0, 0, 0, indicatorMarginBottom);
        uIndicator.setLayoutParams(indicatorLayoutParams);
    }

    /**
     * 设置数据源
     * @param dataBeanList 数据源
     * @param columnNum 网格列数
     * @param perPageNum 每一页的总数目
     */
    public void setData(List<DataBean> dataBeanList, int columnNum, int perPageNum) {
        if (this.dataBeanList.size() > 0) {
            this.dataBeanList.clear();
        }
        if (gridList.size() > 0) {
            gridList.clear();
        }
        //初始化数据
        // TODO: 2019-07-24 测试数据待删除
        for (int i = 0; i < 3; i++) {
            DataBean bean = new DataBean();
            bean.name = "第" + (i + 1) + "条";
            this.dataBeanList.add(bean);
        }
        //计算viewpager一共显示几页
        int pageSize = this.dataBeanList.size() % perPageNum == 0
                ? this.dataBeanList.size() / perPageNum
                : this.dataBeanList.size() / perPageNum + 1;
        for (int i = 0; i < pageSize; i++) {
            GridView gridView = new GridView(context);
            GridViewAdapter adapter = new GridViewAdapter(context, this.dataBeanList
                    , i, perPageNum);
            adapter.setOnGridViewAdapterListener(this);
            gridView.setNumColumns(columnNum);
            gridView.setAdapter(adapter);
            gridList.add(gridView);
        }

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(gridList, context);
        viewPager.setAdapter(viewPagerAdapter);
        //指示器
        uIndicator.attachToViewPager(viewPager);
    }

    @Override
    public void clickItem(DataBean dataBean) {
        if (null != xxtGridMenuViewListener) {
            xxtGridMenuViewListener.clickItem(dataBean);
        }
    }

    public interface XXTGridMenuViewListener {
        // TODO: 2019-07-24 待调整
        void clickItem(DataBean dataBean);
    }

    public void setXxtGridMenuViewListener(XXTGridMenuViewListener xxtGridMenuViewListener) {
        this.xxtGridMenuViewListener = xxtGridMenuViewListener;
    }
}
