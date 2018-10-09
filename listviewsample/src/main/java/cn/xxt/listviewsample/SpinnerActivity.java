package cn.xxt.listviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * 下拉框
 * @author zhq
 * @date 2018/6/26 下午7:00
 */
public class SpinnerActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener{

    private Spinner spFirst;

    private Spinner spSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spFirst = findViewById(R.id.sp_first);
        spSecond = findViewById(R.id.sp_second);

        String[] arr = {"初识Android开发", "Android中级开发", "Android高级开发", "Android开发进阶"};

        //使用ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arr);

        spSecond.setAdapter(adapter);

        spFirst.setOnItemSelectedListener(this);
        spSecond.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String content = parent.getItemAtPosition(position).toString();

        switch (parent.getId()) {
            case R.id.sp_first:
                Toast.makeText(SpinnerActivity.this, "选择的专业是:" + content,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.sp_second:
                Toast.makeText(SpinnerActivity.this, "选择的教材是：" + content,
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
