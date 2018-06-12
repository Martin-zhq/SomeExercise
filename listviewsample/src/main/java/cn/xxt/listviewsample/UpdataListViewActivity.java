package cn.xxt.listviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

/**
 * 简单进行假数据增删改查的listview
 * @author zhq
 * @date 2018/6/8 下午4:51
 */
public class UpdataListViewActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;

    private Button btnAdd;

    private Button btnUpdate;

    private Button btnDelete;

    private Button btnClear;

    private MyUpdateDataAdapter myUpdateDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_list_view);

        listView = findViewById(R.id.listview);
        btnAdd = findViewById(R.id.btn_add_data);
        btnUpdate = findViewById(R.id.btn_update_data);
        btnDelete = findViewById(R.id.btn_delete_data);
        btnClear = findViewById(R.id.btn_clear_data);

        btnAdd.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        View emptyView = findViewById(R.id.tv_empty);
        listView.setEmptyView(emptyView);

        List<UpdateData> dataList = new LinkedList<>();
        myUpdateDataAdapter = new MyUpdateDataAdapter(this, dataList);
        listView.setAdapter(myUpdateDataAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_data:
                addItem();
                break;
            case R.id.btn_update_data:
                updateData();
                break;
            case R.id.btn_delete_data:
                deleteItem();
                break;
            case R.id.btn_clear_data:
                clearData();
                break;
            default:
                break;
        }
    }

    /**
     * 添加列表项
     */
    private void addItem() {
        int position = getRandomPosition();
        myUpdateDataAdapter.add(position, new UpdateData(R.drawable.face6, "随机添加" + position));
    }

    /**
     * 更新列表内容
     */
    private void updateData() {
        int position = getRandomPosition();
        myUpdateDataAdapter.update(position, new UpdateData(R.drawable.face1, "更新了" + getRandomNumber()));
    }

    /**
     * 删除列表项
     */
    private void deleteItem() {
        int position = getRandomPosition();
        myUpdateDataAdapter.remove(position);
    }

    /**
     * 清空列表数据
     */
    private void clearData() {
        myUpdateDataAdapter.clear();
    }


    /**
     * 随机获取列表内的位置
     * @return
     */
    private int getRandomPosition() {
        int count = myUpdateDataAdapter.getCount();
        return (int) (Math.random() * count);
    }

    /**
     * 获取100内的随机数
     * @return
     */
    private double getRandomNumber() {
        return Math.random() * 100;
    }
}
