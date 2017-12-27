package cn.xxt.recyclerviewexercise.widgetexercise;

import android.app.AlarmManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void clickBtnTwoButton(View view) {
        new AlertDialog.Builder(this).setIcon(R.drawable.face1).
                setTitle("是否下载文件?").setPositiveButton("是",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new AlertDialog.Builder(DialogActivity.this).setMessage("文件下载成功")
                                .create().show();
                    }
                }).setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new AlertDialog.Builder(DialogActivity.this).setMessage("您已取消下载")
                                .create().show();
                    }
                }).show();

    }

    public void clickBtnThreeButton(View view) {
        new AlertDialog.Builder(this).setIcon(R.drawable.dialog).setTitle("是否覆盖文件")
                .setPositiveButton("覆盖",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                new AlertDialog.Builder(DialogActivity.this).setMessage("文件已覆盖")
                                        .create().show();
                            }
                        }).setNegativeButton("忽略",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new AlertDialog.Builder(DialogActivity.this).setMessage("您忽略了覆盖文件的操作")
                                .create().show();
                    }
                }).setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new AlertDialog.Builder(DialogActivity.this).setMessage("你取消了覆盖操作")
                                .create().show();
                    }
                }).show();
    }
}
