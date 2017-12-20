package cn.xxt.recyclerviewexercise.menuexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/20 下午4:10
 */
public class SubMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //添加子菜单
        SubMenu fileSubMenu = menu.addSubMenu(1, 1, 2, "文件");
        //设置在选项菜单中显示的图像。
        fileSubMenu.setIcon(R.mipmap.delete);
        //设置子菜单头的图像
        fileSubMenu.setHeaderIcon(R.mipmap.delete);
        //在子菜单fileSubMenu中添加菜单项
        MenuItem newMenuItem = fileSubMenu.add(1, 2, 2, "新建");
        //将这个菜单项设置成复选框类型。。
        newMenuItem.setCheckable(true);
        //把这个菜单项设置成选中状态
        newMenuItem.setChecked(true);

        //添加另外的两个菜单项
        MenuItem openMenuItem = fileSubMenu.add(2, 3, 3, "打开");
        MenuItem exitMenuItem = fileSubMenu.add(2, 4, 4, "退出");
        exitMenuItem.setChecked(true);
        //设置groupId为2的 为一组选项按钮类型。。。
        fileSubMenu.setGroupCheckable(2, true, true);

        return super.onCreateOptionsMenu(menu);
    }
}
