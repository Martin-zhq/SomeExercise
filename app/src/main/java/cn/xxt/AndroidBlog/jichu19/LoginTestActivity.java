package cn.xxt.AndroidBlog.jichu19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.xxt.recyclerviewexercise.R;

/**
 *
 * @author zhq
 * @date 2018/4/14 上午9:14
 */
public class LoginTestActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);

        etUserName = findViewById(R.id.et_user_name);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginTestActivity.this, etUserName.getText().toString() +
                        etPassword.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
