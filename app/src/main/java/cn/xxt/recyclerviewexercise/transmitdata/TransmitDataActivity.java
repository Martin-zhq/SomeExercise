package cn.xxt.recyclerviewexercise.transmitdata;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import cn.xxt.recyclerviewexercise.R;

public class TransmitDataActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnIntentData;

    private Button btnStaticData;

    private Button btnClipboardData;

    private Button btnApplicationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmit_data);
        initViews();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_intent: {
                intent = new Intent(this, MyActivity1.class);
                //保存String类型的数据
                intent.putExtra("intent_string", "通过intent传递字符串");
                //integer类型
                intent.putExtra("intent_integer", 666);
                Data data = new Data();
                data.id = 1;
                data.name = "somebody";
                //保存可序列化的对象
                intent.putExtra("intent_data", data);
                startActivity(intent);
                break;
            }
            case R.id.btn_static_data:{
                intent = new Intent(this, MyActivity2.class);
                //跳转前为静态变量赋值
                MyActivity2.id = 666;
                MyActivity2.name = "静态变量传值";
                Data data = new Data();
                data.id = 555;
                data.name = "kaixin";
                MyActivity2.data = data;
                startActivity(intent);
                break;
            }
            case R.id.btn_clipboard_data:{
                intent = new Intent(this, MyActivity3.class);
                //获取剪切板对象
                ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                Data clipboardData = new Data();
                clipboardData.id = 6969696;
                clipboardData.name = "剪切板传值。。。";
                //创建字节数组输出流对象，用于将Data对象转换为字节流
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                //用于保存Data对象生成的Base64格式的字符串
                String base64Str = "";

                try{
                    ObjectOutputStream oos = new ObjectOutputStream(baos);
                    //将data对象写入对象输出流
                    oos.writeObject(clipboardData);
                    base64Str = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
                    oos.close();
                } catch (Exception e) {

                }
                //获取存储文本数据的剪切板数据对象（ClipData）
                ClipData clipData = ClipData.newPlainText("data", base64Str);
                //设置主剪切板
                manager.setPrimaryClip(clipData);
                startActivity(intent);
                break;
            }
            case R.id.btn_application_data:
                intent = new Intent(this, MyActivity4.class);
                //获取全局对象
                MyApp myApp = (MyApp) getApplicationContext();
                myApp.country = "中国";
                myApp.data.id = 12456;
                myApp.data.name = "全局对象";
                startActivity(intent);
                break;

            default:
                break;
        }

    }

    private void initViews() {
        btnIntentData = findViewById(R.id.btn_intent);
        btnStaticData = findViewById(R.id.btn_static_data);
        btnClipboardData = findViewById(R.id.btn_clipboard_data);
        btnApplicationData = findViewById(R.id.btn_application_data);

        btnIntentData.setOnClickListener(this);
        btnStaticData.setOnClickListener(this);
        btnClipboardData.setOnClickListener(this);
        btnApplicationData.setOnClickListener(this);
    }


}
