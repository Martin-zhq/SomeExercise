package cn.xxt.recyclerviewexercise.fragmentexercise;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/1/8 上午10:21
 */
public class FragmentArgumentActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_argument);

        editText = findViewById(R.id.et_show_data);
    }


    public void clickBtnSendData(View view) {
        MyFragment3 fragment3 = new MyFragment3();
        //创建传递数据的bundle对象
        Bundle bundle = new Bundle();
        //指定了一个key-value
        bundle.putString("name", "Hello , this is value");
        //setArguments()方法必须在onAttach()方法调用前调用
        fragment3.setArguments(bundle);
        //获取FragmentManager对象
        FragmentManager fragmentManager = getFragmentManager();
        //开始Fragment事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //将Fragment添加到事务中，并指定一个tag
        fragmentTransaction.add(R.id.frame_container2, fragment3, "fragment3");
        //提交Fragment事务
        fragmentTransaction.commit();
        Toast.makeText(this, "数据已成功传递", Toast.LENGTH_SHORT).show();
    }

    /**
     * Fragment中按钮的点击事件
     * @param view
     */
    public void clickBtnShowArgument(View view) {
        String name = getFragmentManager().findFragmentByTag("fragment3").getArguments().getString("name");
        editText.setText(name);
    }
}
