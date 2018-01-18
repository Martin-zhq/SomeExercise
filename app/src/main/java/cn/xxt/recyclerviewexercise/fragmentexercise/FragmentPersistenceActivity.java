package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;

public class FragmentPersistenceActivity extends AppCompatActivity {

    /**在onSaveInstanceState方法中保存Fragment字段的值 */
    private MyFragment4 myFragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_persistence);

        FragmentManager manager = getFragmentManager();
        if (savedInstanceState != null) {
            //恢复Fragment字段的值
            myFragment4 = (MyFragment4) manager.getFragment(savedInstanceState, "fragment");
            if (myFragment4 == null) {
                //创建myFragment4的值
                myFragment4 = (MyFragment4) getFragmentManager().findFragmentById(R.id.fragment_persistence);
            }
        }
    }

    public void clickBtnSetDataInFragment(View view) {
        if (myFragment4 != null) {
            //设置name字段的值
            myFragment4.name = "name:新的字段值";
            //设置name参数的值
            myFragment4.getArguments().putString("name", "arg:新设置的值");
            Toast.makeText(this, "成功为name赋值", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickBtnReadDataFromFragment(View view) {
        if (myFragment4 != null) {
            //显示name字段的值
            Toast.makeText(this, myFragment4.name, Toast.LENGTH_SHORT).show();
            //显示name参数的值
            Toast.makeText(this, myFragment4.getArguments().getString("name"), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (myFragment4 != null) {
            //保存Fragment字段的值，key是fragment
            getFragmentManager().putFragment(outState, "fragment", myFragment4);
        }
        super.onSaveInstanceState(outState);
    }
}
