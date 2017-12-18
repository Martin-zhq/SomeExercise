package cn.xxt.recyclerviewexercise.invokeotheractivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;

/**
 * @author zhq
 */
public class InvokeOtherActivity extends AppCompatActivity {

    private Context mContext;

    private Class mClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoke_other);

        try {
            //创建指向外部程序MyWebBrowser的context对象，cn.xxt.mywebbrowser是指向MyWebBrowser的
            //package name
            //CONTEXT_INCLUDE_CODE运行代码被装载
            //CONTEXT_IGNORE_SECURITY忽略任何安全限制
            mContext = createPackageContext("cn.xxt.mywebbrowser", Context.CONTEXT_INCLUDE_CODE |
            Context.CONTEXT_IGNORE_SECURITY);
            //动态装载MyWebBrowser类
            mClass = mContext.getClassLoader().loadClass("cn.xxt.mywebbrowser.MainActivity");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickBtnAction(View view) {
        //指定了action和要浏览的页面的uri
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/nokiaguy"));
        startActivity(intent);
    }

    public void clickBtnSetClassName(View view) {
        //直接指定packageName 和 className
        Intent intent = new Intent();
        intent.setClassName("cn.xxt.mywebbrowser", "cn.xxt.mywebbrowser.MainActivity");
        intent.setData(Uri.parse("http://nokiaguy.blogjava.net"));
        startActivity(intent);
    }

    public void clickBtnSetClassNameContext(View view) {
        //指定context对象和className
        if (mContext == null || mClass == null) {return;}
        Intent intent = new Intent();
        intent.setClassName(mContext, "cn.xxt.mywebbrowser.MainActivity");
        intent.setData(Uri.parse("http://nokiaguy.cnblogs.com"));
        startActivity(intent);
    }

    public void clickBtnSetClass(View view) {
        if (mContext == null || mClass == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mContext, mClass);
        intent.setData(Uri.parse("http://nokiaguy.cnblogs.com"));
        startActivity(intent);
    }

    public void clickBtnSetComponentName(View view) {
        if (mContext == null || mClass == null) { return; }
        //指定ComponentName对象，ComponentName对象指定了context对象和class对象
        ComponentName componentName = new ComponentName(mContext, mClass);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.setData(Uri.parse("http://nokiaguy.cnblogs.com"));
        startActivity(intent);
    }

    public void clickBtnCalculator(View view) {
        //通过指定packageName和className来跳转到系统计算器   找不到类。。
//        Intent intent = new Intent();
//        intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
//        startActivity(intent);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
        startActivity(intent);
    }

}
