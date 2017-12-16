package cn.xxt.recyclerviewexercise.transmitdata;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class MyActivity3 extends AppCompatActivity {

    private TextView tvClipboardData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my3);

        tvClipboardData = findViewById(R.id.tv_clipboard_data);
        //获取剪切板对象
        ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        //从剪切板中获取Base64编码的字符串
        String base64Str = manager.getPrimaryClip().getItemAt(0).getText().toString();
        //将Base64编码字符串解码成字节数组
        byte[] buffer = Base64.decode(base64Str, Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            //将字节流还原成Data对象
            Data data = (Data)ois.readObject();
            //同时显示base64编码和原字段值
            tvClipboardData.setText(base64Str + "\n\ndata.id:" + data.id + "\ndata.name:"
            + data.name);
        } catch (Exception e) {
            
        }
    }
}
