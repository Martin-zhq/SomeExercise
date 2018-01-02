package cn.xxt.recyclerviewexercise.widgetexercise;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.Random;

import cn.xxt.recyclerviewexercise.R;

/**
 * 对话框
 * @author zhq
 * @date 2017/12/28 下午4:32
 */
public class DialogActivity extends AppCompatActivity {

    private final String[] provinces = {"河南", "河北", "安徽", "山东", "山西", "辽宁", "海南"};

    private  int index = -1;

    private ListView lv;

    /** 进度对话框相关变量 */
    private static final int MAX_PROGRESS = 100;

    private ProgressDialog progressDialog;

    private Handler progressHandler;

    private int progress;


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

    public void clickBtnSimpleList(View view) {

        new AlertDialog.Builder(this).setTitle("选择省份").setItems(provinces, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final AlertDialog ad = new AlertDialog.Builder(DialogActivity.this)
                        .setMessage("您选择了：" + which + ":" + provinces[which]).show();
                android.os.Handler handler = new android.os.Handler();
                //设置定时器，5秒后调用run方法
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ad.dismiss();
                    }
                }, 5 * 1000);
            }
        }).show();
    }

    public void clickBtnSingleChoice(View view) {

        new AlertDialog.Builder(this).setTitle("选择省份")
                .setSingleChoiceItems(provinces, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                       index = which;
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new AlertDialog.Builder(DialogActivity.this).setMessage("您选择了" + index + ":" + provinces[index])
                        .show();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new AlertDialog.Builder(DialogActivity.this).setMessage("你啥都没选哪").show();
            }
        }).show();
    }

    public void clickBtnMultiChoice(View view) {
        AlertDialog ad = new AlertDialog.Builder(DialogActivity.this).setIcon(R.drawable.dialog)
                .setTitle("选择省份")
                .setMultiChoiceItems(provinces, new boolean[]{
                        true, false, false, true, false, true, false
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int count = lv.getCount();
                        String s = "您选择了：";
                        for (int i = 0; i < provinces.length; i++) {
                            if (lv.getCheckedItemPositions().get(i)) {
                                s += i + ":" + lv.getAdapter().getItem(i) + " ";
                            }
                        }
                        if (lv.getCheckedItemPositions().size() > 0) {
                            new AlertDialog.Builder(DialogActivity.this).setMessage(s).show();
                        } else {
                            new AlertDialog.Builder(DialogActivity.this).setMessage("您未选择任何省份").show();
                        }
                    }
                }).setNegativeButton("取消", null).create();
        lv = ad.getListView();
        ad.show();
    }

    public void clickBtnHorizontal(View view) {
        showProgressDialog(ProgressDialog.STYLE_HORIZONTAL);
    }

    public void clickBtnVertical(View view) {
        showProgressDialog(ProgressDialog.STYLE_SPINNER);
    }

    /** 显示进度对话框 */
    private void showProgressDialog(int style) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(R.drawable.dialog);
        progressDialog.setTitle("正在处理数据");
        progressDialog.setMessage("请稍后...");
        //设置进度对话框的风格
        progressDialog.setProgressStyle(style);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.setButton("暂停", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //通过删除消息代码的方式停止定时器
                progressHandler.removeMessages(1);
            }
        });
        progressDialog.setButton2("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //通过删除消息代码的方式停止定时器的执行
                progressHandler.removeMessages(1);
                //回复初始进度值
                progress = 0;
                progressDialog.setProgress(0);
            }
        });
        progressDialog.show();
        progressHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (progress >= MAX_PROGRESS) {
                    //进度达到最大值
                    progress = 0;
                    progressDialog.dismiss();
                } else {
                    progress++;
                    //将进度递增1
                    progressDialog.incrementProgressBy(1);
                    //随机设置下一次递增进度的时间
                    progressHandler.sendEmptyMessageDelayed(1, 50 + new Random().nextInt(500));
                }
            }
        };
        //设置进度初始值
        progress = (progress > 0) ? progress : 0;
        progressDialog.setProgress(progress);
        progressHandler.sendEmptyMessage(1);
    }

}
