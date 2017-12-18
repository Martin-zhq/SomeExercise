package cn.xxt.recyclerviewexercise.systemactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class SystemActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCall;

    private Button btnDial;

    private Button btnTouchDialer;

    private Button btnView;

    private Button btnContacts;

    private Button btnSettings;

    private Button btnWifiSettings;

    private Button btnAudio;

    private Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);

        initViews();
    }

    private void initViews() {
        btnCall = findViewById(R.id.btn_call);
        btnDial = findViewById(R.id.btn_dial);
        btnTouchDialer = findViewById(R.id.btn_touch_dialer);
        btnView = findViewById(R.id.btn_view);
        btnContacts = findViewById(R.id.btn_contacts);
        btnSettings = findViewById(R.id.btn_settings);
        btnWifiSettings = findViewById(R.id.btn_wifi_settings);
        btnAudio = findViewById(R.id.btn_audio);
        btnHome = findViewById(R.id.btn_home);

        btnCall.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnTouchDialer.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnContacts.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
        btnWifiSettings.setOnClickListener(this);
        btnAudio.setOnClickListener(this);
        btnHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_call: {
                //第一个参数为字符串形式的Action，第二个参数是uri的值
                try {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
                    startActivity(intent);
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
                break;
            }
            case R.id.btn_dial:{
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:10086"));
                startActivity(intent);
                break;
            }
            case R.id.btn_touch_dialer:{
                Intent intent = new Intent("com.android.phone.action.TOUCH_DIALER");
                startActivity(intent);
                break;
            }
            case R.id.btn_view:{
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/nokiaguy"));
                startActivity(intent);
                break;
            }
            case R.id.btn_contacts:{
                Intent intent = new Intent("com.android.contacts.action.LIST_CONTACTS");
                startActivity(intent);
                break;
            }
            case R.id.btn_settings:{
                Intent intent = new Intent("android.settings.SETTINGS");
                startActivity(intent);
                break;
            }
            case R.id.btn_wifi_settings:{
                Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                startActivity(intent);
                break;
            }
            case R.id.btn_audio:{
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/*");
                startActivity(Intent.createChooser(intent, "选择音频程序"));
                break;
            }
            case R.id.btn_home:{
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                startActivity(intent);
                break;
            }
            default:
                break;
        }
    }
}
