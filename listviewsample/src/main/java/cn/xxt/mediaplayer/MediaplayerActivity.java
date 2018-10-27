package cn.xxt.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;

import cn.xxt.listviewsample.R;

/**
 * Mediaplayer播放音频测试
 * @author zhq
 * @date 2018/10/10 下午3:48
 */
public class MediaplayerActivity extends AppCompatActivity implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener {

    private Button play, pause, stop;
    private MediaPlayer player;
    private SeekBar mSeekBar;
    private TextView tv, tv2;

    private boolean hadDestroy = false;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0x01:
                    break;
                default:
                    break;
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (!hadDestroy) {
                mHandler.postDelayed(this, 1000);
                int currentTime = Math.round(player.getCurrentPosition() / 1000);
                String currentStr = String.format("%s%02d:%02d", "当前时间 ",	currentTime / 60, currentTime % 60);
                tv.setText(currentStr);
                mSeekBar.setProgress(player.getCurrentPosition());
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        mSeekBar = findViewById(R.id.seekbar);
        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);

        mSeekBar.setOnSeekBarChangeListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        player = new MediaPlayer();
        initMediaplayer();
    }




    /** 初始化播放器*/
    private void initMediaplayer() {
        try {
            player = new MediaPlayer();
            File file = new File("/storage/emulated/0/netease/cloudmusic/Music/简弘亦 - 小幸运(Cover 田馥甄).mp3");

            player.setDataSource(file.getPath());
            Log.e("播放器", file.toString());

            player.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (!player.isPlaying()) {
                    player.start();
                    int totalTime = Math.round(player.getDuration() / 1000);
                    String str = String.format("%02d:%02d", totalTime / 60, totalTime % 60);
                    tv2.setText(str);
                    mSeekBar.setMax(player.getDuration());
                    mHandler.postDelayed(runnable, 1000);
                }
                break;
            case R.id.pause:
                if (player.isPlaying()) {
                    player.pause();
                }
                break;
            case R.id.stop:
                if (player.isPlaying()) {
                    player.reset();
                    initMediaplayer();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            if (player != null) {
                player.seekTo(seekBar.getProgress());
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO 自动生成的方法存根
    }
    @Override	public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO 自动生成的方法存根
    }
    @Override	protected void onDestroy() {
        // TODO 自动生成的方法存根
        super.onDestroy();
        if (player != null) {
            player.stop();
            hadDestroy = true;
            player.release();
        }
    }
}



