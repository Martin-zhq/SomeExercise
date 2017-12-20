package cn.xxt.recyclerviewexercise.menuexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/20 下午4:53
 */
public class CustomMenuActivity extends AppCompatActivity {

    private PopupWindow popupWindow;

    private View parentLayout;

    /** 默认为1未弹出，2为弹出*/
    private int state = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_menu);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            //按下"menu"键的动作
            case KeyEvent.KEYCODE_MENU:{
                //如果选项菜单已弹出，不再弹出新窗口
                if (state == 2) {
                    return false;
                }
                //装载选项菜单的布局
                parentLayout = getLayoutInflater().inflate(R.layout.custom_menu, null);
                //创建PopupWindow，并在指定位置弹出显示菜单的窗口。
                popupWindow = new PopupWindow(parentLayout, getWindowManager().getDefaultDisplay().getWidth()
                , getWindowManager().getDefaultDisplay().getHeight());
                //设置弹出窗口的位置
                popupWindow.showAtLocation(parentLayout, Gravity.BOTTOM, 0, 0);
                LinearLayout home = parentLayout.findViewById(R.id.ll_home);
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CustomMenuActivity.this, "单击定制菜单", Toast.LENGTH_SHORT).show();
                        //点击首页后，关闭选项菜单
                        popupWindow.dismiss();
                        //将状态置为未打开
                        state = 1;
                    }
                });
                //选项菜单弹出后，将状态变量设为2，表示已打开
                state = 2;
                return false;
            }

            case KeyEvent.KEYCODE_BACK:{
                //点击返回键
                if (state == 2) {
                    //已打开，则关闭并设置状态为未打开
                    popupWindow.dismiss();
                    state = 1;
                } else if (state == 1) {
                    //未打开,直接关闭页面
                    finish();
                }
                return false;
            }

            default:
                break;
        }
        //除了menu和back按下事件外，仍需调用onKeyDown方法来相应其他键的按下事件
        return super.onKeyDown(keyCode, event);
    }

}
