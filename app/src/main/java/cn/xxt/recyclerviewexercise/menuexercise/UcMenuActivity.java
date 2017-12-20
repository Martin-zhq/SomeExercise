package cn.xxt.recyclerviewexercise.menuexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/20 下午7:17
 */
public class UcMenuActivity extends AppCompatActivity implements View.OnKeyListener, AdapterView.OnItemClickListener{

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc_menu);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:{
                //监听返回键，如果窗口已经显示，则关闭它
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                break;
            }
            default:
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //单击GridView的每一项执行的动作
        popupWindow.dismiss();
        Toast.makeText(this, UcMenuConst.GRID_ITEM_TEXT_LIST[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //必须创建一项 ，否则系统不会调用onMenuOpened方法
        menu.add("menu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                //菜单已显示，关闭它
                popupWindow.dismiss();
            } else {
                //菜单未显示，弹出菜单
                View parentLayout = getLayoutInflater().inflate(R.layout.activity_uc_menu, null);
                popupWindow.showAtLocation(parentLayout, Gravity.CENTER, 0, 0);
            }
        }
        //返回false，不会显示在onCreateOptionsMenu方法中创建的菜单
        return false;
    }
}
