package cn.xxt.recyclerviewexercise.resourcees;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/21 下午2:51
 */
public class LevelListActivity extends AppCompatActivity {

    private ImageView ivLevelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_list);

        ivLevelList = findViewById(R.id.iv_level_list);
        //设置level为8，显示花
        ivLevelList.setImageLevel(8);
    }

    public void clickBtnFlower(View view) {
        ivLevelList.setImageLevel(12);
    }

    public void clickBtnLeaf(View view) {
        ivLevelList.getDrawable().setLevel(20);
    }

}
