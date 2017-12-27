package cn.xxt.recyclerviewexercise.widgetexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Random;

import cn.xxt.recyclerviewexercise.R;
/**
 * listView增删改列表项
 * @author zhq
 * @date 2017/12/27 上午10:57
 */
public class DynamicListViewActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener
,AdapterView.OnItemSelectedListener{

    private String[] data = new String[] {"蛮王", "盖伦", "艾希", "卡特琳娜", "莫西亚", "莫甘娜"};

    private int selectedIndex;

    private ListView lvDyanmic;

    private Button btnAddText;

    private Button btnAddImage;

    private Button btnDeleteItem;

    private Button btnModify;

    private Button btnClear;

    private ViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list_view);

        lvDyanmic = findViewById(R.id.lv_dynamic);
        btnAddText = findViewById(R.id.btn_add_text);
        btnAddImage = findViewById(R.id.btn_add_image);
        btnDeleteItem = findViewById(R.id.btn_remove);
        btnClear = findViewById(R.id.btn_clear);
        btnModify = findViewById(R.id.btn_modify);

        adapter = new ViewAdapter(this);
        lvDyanmic.setAdapter(adapter);
        btnAddText.setOnClickListener(this);
        btnAddImage.setOnClickListener(this);
        btnDeleteItem.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_text:
                int random = new Random().nextInt(data.length);
                adapter.addText(data[random]);
                break;
            case R.id.btn_add_image:
                adapter.addImage(getImageResourceId());
                break;
            case R.id.btn_remove:
                adapter.remove(selectedIndex);
                break;
            case R.id.btn_modify:
                adapter.modify(selectedIndex, data[new Random().nextInt(data.length)]);
                break;
            case R.id.btn_clear:
                adapter.removeAll();
                break;
            default:
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedIndex = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private int getImageResourceId() {
        int[] resourceIds = new int[] {
                R.drawable.face1, R.drawable.face2,R.drawable.face8,
                R.drawable.face3, R.drawable.face4,R.drawable.face5,
                R.drawable.face6, R.drawable.face7,R.drawable.meizi
        };
        return resourceIds[new Random().nextInt(resourceIds.length)];
    }
}
