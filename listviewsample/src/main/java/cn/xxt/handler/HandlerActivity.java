package cn.xxt.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.xxt.listviewsample.R;
/**
 * handler 的sendMessage使用
 * @author zhq
 * @date 2018/10/13 下午4:26
 */
public class HandlerActivity extends AppCompatActivity {

    private TextView tvTip;

    private Button btnStart;

    private boolean isDownloading = false;

    private static final int DOWNLOAD_START = 1;
    private static final int DOWNLOAD_SUCCESS = 2;
    private static final int DOWNLOAD_FAIL = 3;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DOWNLOAD_START:
                    tvTip.setText("Download Start");
                    break;
                case DOWNLOAD_SUCCESS:
                    tvTip.setText("Download Success");
                    break;
                case DOWNLOAD_FAIL:
                    tvTip.setText("Download Fail");
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        initView();
    }

    private void initView() {
        tvTip = findViewById(R.id.tv_tip);
        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isDownloading) {
//                    new MyThread().start();
//                    new PostThread().start();
                    new ObstainThread().start();
                }
            }
        });
    }

    class MyThread extends Thread {
        @Override
        public void run() {

            isDownloading = true;
            handler.sendEmptyMessage(DOWNLOAD_START);
            try {
                //线程sleep模拟下载耗时
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                handler.sendEmptyMessage(DOWNLOAD_FAIL);
            }

            Message msg = new Message();
            msg.what = DOWNLOAD_SUCCESS;
            handler.sendMessage(msg);
            isDownloading = false;
        }
    }


    class PostThread extends Thread {
        @Override
        public void run() {
            isDownloading = true;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvTip.setText("开始下载...");
                }
            });
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvTip.setText("下载成功！");
                }
            });
        }
    }

    class ObstainThread extends Thread {
        @Override
        public void run() {
            isDownloading = true;
            handler.obtainMessage(DOWNLOAD_START).sendToTarget();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
                handler.obtainMessage(DOWNLOAD_FAIL).sendToTarget();
            }
            handler.obtainMessage(DOWNLOAD_SUCCESS).sendToTarget();
            isDownloading = false;
        }
    }
}
