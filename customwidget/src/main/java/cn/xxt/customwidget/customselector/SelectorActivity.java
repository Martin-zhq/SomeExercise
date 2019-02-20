package cn.xxt.customwidget.customselector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import cn.xxt.customwidget.R;

/**
 * @Author zhq
 * @Date 2019/2/19-下午2:15
 * @Description
 * @Email 1457453696@qq.com
 */
public class SelectorActivity extends AppCompatActivity implements Selector.OnSelectorStateListener {

    private SelectorGroup selectorGroup = new SelectorGroup();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        initView();
    }

    @Override
    public void onStateChange(Selector selector, boolean isSelected) {
        String mark = selector.getMark();
        if (isSelected) {
            Toast.makeText(this, mark + "is selected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, mark + "is unselected", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        Selector teenageSelector = findViewById(R.id.selector_1);
        Selector manSelector = findViewById(R.id.selector_2);
        Selector oldManSelector = findViewById(R.id.selector_3);

        teenageSelector.setSelectorStateListener(this).setSelectorGroup(selectorGroup);
        manSelector.setSelectorStateListener(this).setSelectorGroup(selectorGroup);
        oldManSelector.setSelectorStateListener(this).setSelectorGroup(selectorGroup);
    }
}
