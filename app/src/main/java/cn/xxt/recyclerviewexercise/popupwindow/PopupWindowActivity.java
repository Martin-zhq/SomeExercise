package cn.xxt.recyclerviewexercise.popupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;

public class PopupWindowActivity extends AppCompatActivity implements CommonPopupWindow.ViewInterface{
    private CommonPopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
    }

    /**
     * 向左弹出
     * @param view
     */
    public void showPopupWindow(View view) {
        if (popupWindow != null && popupWindow.isShowing()) {
            return;
        }
//        popupWindow = new CommonPopupWindow.Builder(this)
//                .setView(R.layout.up_down_item)
//                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//                .setAnimationStyle(R.style.AnimRight)
//                .setViewOnclickListener(this)
//                .create();
//        popupWindow.showAsDropDown(view, -popupWindow.getWidth(), -view.getHeight());
        popupWindow = new CommonPopupWindow.Builder(this)
                .setView(R.layout.up_down_item)
                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.AnimDown)
                .setViewOnclickListener(this)
                .setOutsideTouchable(true)
                .create();
        popupWindow.showAsDropDown(view);
        //得到button的左上角坐标
//        int[] positions = new int[2];
//        view.getLocationOnScreen(positions);
//        popupWindow.showAtLocation(findViewById(android.R.id.content), Gravity.NO_GRAVITY, 0, positions[1] + view.getHeight());
    }

    @Override
    public void getChildView(View view, int layoutResId) {
        if (layoutResId == R.layout.popup_child_view) {
            TextView tv_like = (TextView) view.findViewById(R.id.tv_like);
            TextView tv_hate = (TextView) view.findViewById(R.id.tv_hate);
            tv_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PopupWindowActivity.this, "赞一个。", Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
            });
            tv_hate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PopupWindowActivity.this, "踩一个。", Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
            });
        }
    }
}
