package cn.xxt.webframework.retrofit2.post;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import cn.xxt.webframework.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 步骤4：创建Retrofit对象
 * 步骤5：创建 网络请求接口 的实例
 * 步骤6：发送网络请求
 * 步骤7：处理返回数据
 * @author zhq
 * @date 2018/10/29 下午3:34
 */
public class PostRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);

        request();
    }

    private void request() {
        //4、创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //5、创建网络请求接口的实例
        PostRequest_Interface postRequest = retrofit.create(PostRequest_Interface.class);

        //对发送请求就行封装
        Call<Translation> call = postRequest.getCall("write the code, change the world");

        //步骤6、发送网络请求
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                if (null != response.body().getTranslateResultBeanList()) {
                    String text = response.body().getTranslateResultBeanList().get(0).get(0).getTgt();
                    Toast.makeText(PostRequestActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                Toast.makeText(PostRequestActivity.this, "defeat!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
