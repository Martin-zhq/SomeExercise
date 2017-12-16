package cn.xxt.recyclerviewexercise.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class ResultActivity extends AppCompatActivity {

    private EditText etResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        etResult = findViewById(R.id.et_result);
    }

    public void clickBtn(View view) {
        String resultStr = etResult.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("result", resultStr);
        setResult(2, intent);
        finish();
    }
}
