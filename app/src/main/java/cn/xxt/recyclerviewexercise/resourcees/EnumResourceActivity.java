package cn.xxt.recyclerviewexercise.resourcees;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Field;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/21 下午2:08
 */
public class EnumResourceActivity extends AppCompatActivity {

    private EditText etResourceName;

    private TextView tvResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum_resource);
        etResourceName = findViewById(R.id.et_resource_name);
        tvResourceId = findViewById(R.id.tv_resource_value);
    }

    /**
     * 跟据资源名称获取资源id
     * @param resourceName
     * @return
     */
    private int getResourceId(String resourceName) {
        //获取R类中所有的内嵌类
        Class[] resourceClasses = R.class.getClasses();
        //遍历所有的内嵌类
        for (Class resourceClass : resourceClasses) {
            try {
                //在当前内嵌类中搜索name指定的常量，不存在则抛出异常。
                Field field = resourceClass.getField(resourceName);
                //搜索到name指定的常量后，获取常量值，由于资源ID都是静态常量，所以对象传入null
                int resourceId = field.getInt(null);
                return resourceId;
            } catch (Exception e) {

            }
        }
        //常量不存在返回-1
        return -1;
    }

    public void clickBtnGetResourceId(View view) {
        String resourceName = String.valueOf(etResourceName.getText());
        int resourceId = getResourceId(resourceName);
        if (resourceId == -1) {
            tvResourceId.setText("资源不存在");
        } else {
            tvResourceId.setText("0x" + Integer.toHexString(resourceId));
        }
    }
}
