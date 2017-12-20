package cn.xxt.recyclerviewexercise.menuexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 * 
 * @author zhq
 * @time 2017/12/20 下午3:40
 */
public class MenuItemClickActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item_click);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        //在此编写菜单项单击事件代码，可根据item参数的getItemId方法判断单击的是哪个菜单项。
        Toast.makeText(this, "你单击的是第" + item.getItemId() + "项~", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem deleteMenuItem = menu.add(1, 2, 2, "删除");
        deleteMenuItem.setIcon(R.mipmap.delete);
        //设置单击"删除"菜单项事件的监听器，因为当前窗口类已经实现了OnMenuItemClickListener接口
        deleteMenuItem.setOnMenuItemClickListener(this);
        return super.onCreateOptionsMenu(menu);
    }
}
