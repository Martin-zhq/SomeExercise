package cn.xxt.recyclerviewexercise.recyclerviewexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import cn.xxt.recyclerviewexercise.R;

/**
 *
 * @author zhq
 * @date 2018/4/9 下午2:40
 */

public class CommentListActivity extends AppCompatActivity {

    private RecyclerView rvCommentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);
    }


}
