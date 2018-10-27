package cn.xxt.audiorecord;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.xxt.listviewsample.R;
/**
 * 录音测试activity
 * @author zhq
 * @date 2018/10/9 下午3:13
 */
public class RecordTestActivity extends AppCompatActivity {

    private final static int FLAG_WAV = 0;
    private final static int FLAG_AMR = 1;
    /** -1:没再录制，0：录制wav，1：录制amr */
    private int mState = -1;
    private Button btnRecordWav;
    private Button btnRecordAmr;
    private Button btnStop;
    private TextView tvRecord;
    private UIHandler uiHandler;
    private UIThread uiThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_test);
        findViewByIds();
        setListeners();
        init();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

    private void findViewByIds() {
        btnRecordWav = findViewById(R.id.btn_record_wav);
        btnRecordAmr = findViewById(R.id.btn_record_amr);
        btnStop = findViewById(R.id.btn_stop_record);
        tvRecord = this.findViewById(R.id.tv_record);
    }

    private void setListeners() {
        btnRecordWav.setOnClickListener(btnRecordWavClickListener);
        btnRecordAmr.setOnClickListener(btnRecordAmrClickListener);
        btnStop.setOnClickListener(btnStopClickListener);
    }

    private void init(){
        uiHandler = new UIHandler();
    }
    private Button.OnClickListener btnRecordWavClickListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            record(FLAG_WAV);
        }
    };
    private Button.OnClickListener btnRecordAmrClickListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            record(FLAG_AMR);
        }
    };
    private Button.OnClickListener btnStopClickListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            stop();
        }
    };

    /**
     * 开始录音
     * @param mFlag，0：录制wav格式，1：录音amr格式
     */
    private void record(int mFlag) {
        if(mState != -1){
            Message msg = new Message();
            // 存放数据
            Bundle b = new Bundle();
            b.putInt("cmd",CMD_RECORDFAIL);
            b.putInt("msg", ErrorCode.E_STATE_RECODING);
            msg.setData(b);
            // 向Handler发送消息,更新UI
            uiHandler.sendMessage(msg);
            return;
        }
        int mResult = -1;
        switch(mFlag){
            case FLAG_WAV:
                AudioRecordFunc audioRecord = AudioRecordFunc.getInstance();
                mResult = audioRecord.startRecordAndFile();
                break;
            case FLAG_AMR:
                MediaRecordFunc mediaRecord = MediaRecordFunc.getInstance();
                mResult = mediaRecord.startRecordAndFile();
                break;
            default:
                break;
        }
        if(mResult == ErrorCode.SUCCESS){
            uiThread = new UIThread();
            new Thread(uiThread).start();
            mState = mFlag;
        }else{
            Message msg = new Message();
            // 存放数据
            Bundle b = new Bundle();
            b.putInt("cmd",CMD_RECORDFAIL);
            b.putInt("msg", mResult);
            msg.setData(b);

            // 向Handler发送消息,更新UI
            uiHandler.sendMessage(msg);
        }
    }
    /**
     * 停止录音
     */
    private void stop(){
        if(mState != -1){
            switch(mState){
                case FLAG_WAV:
                    AudioRecordFunc audioRecord = AudioRecordFunc.getInstance();
                    audioRecord.stopRecordAndFile();
                    break;
                case FLAG_AMR:
                    MediaRecordFunc mediaRecord = MediaRecordFunc.getInstance();
                    mediaRecord.stopRecordAndFile();
                    break;
                default:
                    break;
            }
            if(uiThread != null){
                uiThread.stopThread();
            }
            if(uiHandler != null) {
                uiHandler.removeCallbacks(uiThread);
            }

            Message msg = new Message();
            // 存放数据
            Bundle b = new Bundle();
            b.putInt("cmd",CMD_STOP);
            b.putInt("msg", mState);
            msg.setData(b);
            // 向Handler发送消息,更新UI
            uiHandler.sendMessageDelayed(msg,1000);
            mState = -1;
        }
    }
    private final static int CMD_RECORDING_TIME = 2000;
    private final static int CMD_RECORDFAIL = 2001;
    private final static int CMD_STOP = 2002;
    class UIHandler extends Handler {

        public UIHandler() {

        }
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            Log.d("MyHandler", "handleMessage......");
            super.handleMessage(msg);
            Bundle b = msg.getData();
            int vCmd = b.getInt("cmd");
            switch(vCmd) {
                case CMD_RECORDING_TIME:
                    int vTime = b.getInt("msg");
                    tvRecord.setText("正在录音中，已录制："+vTime+" s");
                    break;
                case CMD_RECORDFAIL:
                    int vErrorCode = b.getInt("msg");
                    String vMsg = ErrorCode.getErrorInfo(RecordTestActivity.this, vErrorCode);
                    tvRecord.setText("录音失败："+vMsg);
                    break;
                case CMD_STOP:
                    int vFileType = b.getInt("msg");
                    switch(vFileType){
                        case FLAG_WAV:
                            AudioRecordFunc audioRecord = AudioRecordFunc.getInstance();
                            long mSize = audioRecord.getRecordFileSize();
                            tvRecord.setText("录音已停止.录音文件:"+AudioFileFunc.getWavFilePath()+"\n文件大小："+mSize);
                            break;
                        case FLAG_AMR:
                            MediaRecordFunc mediaRecord = MediaRecordFunc.getInstance();
                            mSize = mediaRecord.getRecordFileSize();
                            tvRecord.setText("录音已停止.录音文件:"+AudioFileFunc.getAMRFilePath()+"\n文件大小："+mSize);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    class UIThread implements Runnable {
        int mTimeMill = 0;
        boolean vRun = true;

        public void stopThread(){
            vRun = false;
        }

        @Override
        public void run() {
            while(vRun){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                mTimeMill ++;
                Log.d("thread", "mThread........"+mTimeMill);
                Message msg = new Message();
                // 存放数据
                Bundle b = new Bundle();
                b.putInt("cmd",CMD_RECORDING_TIME);
                b.putInt("msg", mTimeMill);
                msg.setData(b);
                // 向Handler发送消息,更新UI
                RecordTestActivity.this.uiHandler.sendMessage(msg);
            }

        }
    }
}
