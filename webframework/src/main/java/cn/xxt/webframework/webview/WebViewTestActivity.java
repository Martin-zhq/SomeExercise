package cn.xxt.webframework.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import cn.xxt.webframework.R;
/**
 * webview测试类
 * @author zhq
 * @date 2019-06-20 10:56
 */
public class WebViewTestActivity extends AppCompatActivity {

    WebView webView;
    WebSettings webSettings;
    TextView tvTitle, tvStartLoad, tvLoading, tvLoadEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_test);

        webView = findViewById(R.id.webview);
        tvTitle = findViewById(R.id.tv_title);
        tvStartLoad = findViewById(R.id.tv_start_load);
        tvLoading = findViewById(R.id.tv_loading);
        tvLoadEnd = findViewById(R.id.tv_load_end);

        webSettings = webView.getSettings();

        webView.loadUrl("http://www.baidu.com/");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                tvStartLoad.setText("开始加载");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                tvLoadEnd.setText("加载结束");
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                tvTitle.setText(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                String progress = newProgress + "%";
                tvLoading.setText(progress);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != webView) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8"
                    , null);
            webView.clearHistory();
            ((ViewGroup)webView.getParent()).removeView(webView);

            webView.destroy();
            webView = null;
        }
    }
}
