package cn.xxt.recyclerviewexercise.menuexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/20 下午4:00
 */
public class DynamicAddMenuItemActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener,
        View.OnClickListener{

    private Menu menu;

    private int menuItemId = Menu.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add_menu_item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "你点击了第" + item.getItemId() + "项", Toast.LENGTH_SHORT)
                .show();
        return false;
    }

    @Override
    public void onClick(View v) {
        //只有单击手机上的menu按钮，onCreateOptionsMenu方法才会被调用。。
        if (menu == null) {
            return;
        }
        //当按下手机的menu按钮后，动态添加五个菜单项
        for (int i = 10; i < 15; i++) {
            int id = menuItemId ++;
            menu.add(1, id, id, "菜单" + i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //保存menu变量
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }
}
