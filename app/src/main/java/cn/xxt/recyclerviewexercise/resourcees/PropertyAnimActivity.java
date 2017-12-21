package cn.xxt.recyclerviewexercise.resourcees;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @time 2017/12/21 下午4:26
 */
public class PropertyAnimActivity extends AppCompatActivity {

    private Button btnMove;

    private Move move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim);

        btnMove = findViewById(R.id.btn_i_move);
    }

    class Move{
        private int x;

        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
            //水平移动按钮
            btnMove.layout(x, btnMove.getTop(), x + btnMove.getMeasuredWidth(), btnMove.getBottom());
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
            //垂直移动按钮
            btnMove.layout(btnMove.getLeft(), y, btnMove.getRight(), y + btnMove.getMeasuredHeight());
        }
    }
    public void clickBtnMoveMe(View view) {
        //装载属性动画资源
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.property_anim);
        //设置要控制的对象
        move = new Move();
        move.setX(250);
        move.setY(500);
        set.setTarget(move);
        //开始动画
        set.start();
    }
}
