package cn.xxt.recyclerviewexercise.popupwindow;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.xxt.recyclerviewexercise.R;

/**
 *
 * @author zhq
 * @date 2018/3/24 上午9:36
 */
public class UpOrDownPopupWindowActivity extends AppCompatActivity implements CommonPopupWindow.ViewInterface{

    private Context context;
    private RecyclerView rvUpOrDown;
    private UporDownAdapter adapter;
    private CommonPopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_or_down_popup_window);
        context = this;
        rvUpOrDown = findViewById(R.id.rv_up_or_down);

        rvUpOrDown.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvUpOrDown.setLayoutManager(layoutManager);
        List<ButtonText> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            ButtonText text = new ButtonText();
            text.setText("点我"+ i);
            list.add(text);
        }
        adapter = new UporDownAdapter(this, list);
        rvUpOrDown.setAdapter(adapter);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.btn_popup) {
                    if (popupWindow != null && popupWindow.isShowing()) {
                        return;
                    }
                    popupWindow = new CommonPopupWindow.Builder(context)
                            .setView(R.layout.popup_child_view)
                            .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                            .setViewOnclickListener(UpOrDownPopupWindowActivity.this)
                            .setOutsideTouchable(true)
                            .create();

                    Display display = getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    //屏幕宽高
                    int width = size.x;
                    int height = size.y;
                    //得到button的左上角坐标
                    int[] positions = new int[2];
                    view.getLocationOnScreen(positions);
                    if (positions[1] + view.getMeasuredHeight() + popupWindow.getHeight() > height) {
                        //向上弹出
                        popupWindow.setAnimationStyle(R.style.AnimUp);
                        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.face5));
                        popupWindow.showAsDropDown(view, -popupWindow.getWidth(), -(popupWindow.getHeight() + view.getMeasuredHeight()));
                    } else {
                        //向下弹出
                        popupWindow.setAnimationStyle(R.style.AnimDown);
                        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.delete_and_complain_dialog_bg));
                        popupWindow.showAtLocation(view.getRootView(), Gravity.NO_GRAVITY,
                                positions[0] - popupWindow.getWidth(), positions[1] + view.getHeight());
                    }
                }
            }
        });
    }

    @Override
    public void getChildView(View view, int layoutResId) {
        if (layoutResId == R.layout.popup_child_view) {
            TextView tv_like = view.findViewById(R.id.tv_like);
            TextView tv_hate = view.findViewById(R.id.tv_hate);
            tv_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(UpOrDownPopupWindowActivity.this, "赞一个。", Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
            });
            tv_hate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(UpOrDownPopupWindowActivity.this, "踩一个。", Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
            });
        }
    }
}
