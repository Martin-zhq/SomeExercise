package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class ShowDateTime extends AppCompatActivity implements View.OnClickListener{

    private Button btnShowDate;

    private Button btnShowTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_date_time);
        setTitle("zenmeshuo");
        btnShowDate = findViewById(R.id.btn_show_date);
        btnShowTime = findViewById(R.id.btn_show_time);
        btnShowDate.setOnClickListener(this);
        btnShowTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_show_date:{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                showDialog("当前日期", sdf.format(new Date()));
                break;
            }

            case R.id.btn_show_time:{
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                showDialog("当前时间", sdf.format(new Date()));
                break;
            }

            default:
                break;
        }
    }

    private void showDialog(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置对话框图标
        builder.setIcon(R.drawable.dialog);
        //标题
        builder.setTitle(title);
        //显示的信息
        builder.setMessage(msg);
        //设置对话框的按钮
        builder.setPositiveButton("确定", null);
        //显示对话框
        builder.create().show();
    }
}
