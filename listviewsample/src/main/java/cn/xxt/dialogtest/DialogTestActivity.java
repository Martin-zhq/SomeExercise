package cn.xxt.dialogtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import cn.xxt.listviewsample.R;

public class DialogTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);

        final Context context = this;

        findViewById(R.id.btn_new_a_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogTestActivity.this);
                LayoutInflater inflater = LayoutInflater.from(DialogTestActivity.this);
                View customLayoutDialog = inflater.inflate(R.layout.custom_layout_dialog, null);
                EditText etInputReason = customLayoutDialog.findViewById(R.id.et_input_reason);

                etInputReason.setOnFocusChangeListener(new View.OnFocusChangeListener(){
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.showSoftInput(v,0);
                        }
                    }
                });

                final Dialog dialog = builder.setView(customLayoutDialog).create();
                dialog.show();
                //自定义布局应该在这里添加，要在dialog.show()的后面
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//                dialog.getWindow().();
                //可以设置显示的位置
                dialog.getWindow().setGravity(Gravity.CENTER);
                //设置dialog在界面中的属性
                dialog.getWindow().setLayout(800, WindowManager.LayoutParams.WRAP_CONTENT);

            }
        });
    }
}
