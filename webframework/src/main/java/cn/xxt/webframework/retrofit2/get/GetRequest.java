package cn.xxt.webframework.retrofit2.get;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
 * @date 2018/10/29 下午2:49
 */
public class GetRequest extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_getrequest);

        //调用网络请求
        request();
    }

    /**
     * 使用Retrofit封装的方法
     */
    private void request() {
        //步骤4、创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                //设置网络请求的url
                .baseUrl("http://fy.iciba.com")
                //设置使用Gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //步骤5、创建网络请求接口的 实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        //对发送请求进行封装
        Call<Translation> call = request.getCall();

        //步骤6、发送网络请求（异步）
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                //请求成功
                response.body().showData();
                Toast.makeText(GetRequest.this, "response", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                System.out.println("哪里有问题！！！");
            }
        });
    }
}
