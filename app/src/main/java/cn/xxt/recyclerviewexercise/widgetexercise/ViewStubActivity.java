package cn.xxt.recyclerviewexercise.widgetexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import cn.xxt.recyclerviewexercise.R;

public class ViewStubActivity extends AppCompatActivity {

    private ViewStub viewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);

    }

    public void clickBtnMyButton(View view) {
        //viewStub控件只能获取一次，再次获取则为null。
        viewStub = findViewById(R.id.viewstub);

        if (viewStub != null) {

            viewStub.inflate();

//            viewStub.setVisibility(View.VISIBLE);
        } else {
            setTitle("viewStub is null!");
        }



    }
}
