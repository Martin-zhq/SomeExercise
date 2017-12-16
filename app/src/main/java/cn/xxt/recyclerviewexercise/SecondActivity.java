package cn.xxt.recyclerviewexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhq
 */
public class SecondActivity extends AppCompatActivity implements SecondAdapter.SecondListener{

    private RecyclerView recyclerView;

    private List<Person> personList;

    private SecondAdapter secondAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initData();
        initView();
    }

    @Override
    public void clickSecondAdapterItem(int position) {
//        Intent intent = new Intent();
//        intent.setClass(SecondActivity.this, MainActivity.class);
//        startActivity(intent);
        removePerson(position);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        secondAdapter = new SecondAdapter(personList);
        secondAdapter.setSecondListener(this);

        recyclerView.setAdapter(secondAdapter);
    }

    private void initData() {
        personList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Person person = new Person();
            person.setImageId(R.drawable.ic_launcher_background);
            person.setName("鸣人" + i);
            person.setSignatuer("影分身" + i);
            personList.add(person);
        }
    }

    /**
     * 添加数据
     * @param position
     */
    private void addPerson(int position) {
        Person person = new Person();
        person.setImageId(R.drawable.ic_launcher_foreground);
        person.setName("名字");
        person.setSignatuer("签名签名签名签名签名");
        personList.add(position, person);
        secondAdapter.notifyItemInserted(position);
    }

    /**
     * 移除数据
     * @param position
     */
    private void removePerson(int position) {
        personList.remove(position);
        secondAdapter.notifyItemRemoved(position);
        secondAdapter.notifyDataSetChanged();
    }
}
