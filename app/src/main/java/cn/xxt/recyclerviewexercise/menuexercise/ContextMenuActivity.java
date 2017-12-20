package cn.xxt.recyclerviewexercise.menuexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/20 下午4:36
 */
public class ContextMenuActivity extends AppCompatActivity {

    private Button btnMenu;

    private TextView tvMenu;

    private EditText etMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        btnMenu = findViewById(R.id.btn);
        tvMenu = findViewById(R.id.tv_menu);
        etMenu = findViewById(R.id.et_menu);

        //给这些控件都注册  上下文菜单，长按这些控件就会显示出来。
        registerForContextMenu(btnMenu);
        registerForContextMenu(tvMenu);
        registerForContextMenu(etMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("上下文菜单");
        menu.setHeaderIcon(R.mipmap.delete);
        //添加3个上下文菜单项，Menu.NONE = 0
        menu.add(0, 1, Menu.NONE, "菜单项1").setCheckable(true).setChecked(true);
        menu.add(20, 2, Menu.NONE, "菜单项2").setChecked(true);
        menu.add(20, 3, Menu.NONE, "菜单项3");
        menu.setGroupCheckable(20, true, true);
        //添加带子菜单的上下文菜单项
        SubMenu subMenu = menu.addSubMenu(0, 4, Menu.NONE, "子菜单");
        subMenu.add("子菜单项1");
        subMenu.add("子菜单项2");

    }
}
