package cn.xxt.recyclerviewexercise.dragview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import cn.xxt.recyclerviewexercise.R;
/**
 *
 * @author zhq
 * @date 2018/1/5 下午4:18
 */
public class FirstDragDropActivity extends AppCompatActivity implements View.OnDragListener{

    /**目标区域视图*/
    private FrameLayout frameLayoutDragDrop;

    /**要拖动的视图*/
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_drag_drop);

        frameLayoutDragDrop = findViewById(R.id.framelayout_dragdrop);
        imageView = findViewById(R.id.iv_dragdrop);
        frameLayoutDragDrop.setOnDragListener(this);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //创建拖动阴影图像
                View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView);
                //开始拖动，startDrag方法的第一个参数是一个clipdata类型的对象，用于传递剪切板数据，可以为null
                v.startDrag(null, myShadow, null, 0);
                return true;
            }
        });
    }

    /**
     * 处理拖放事件
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onDrag(View v, DragEvent event) {

        int action = event.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                //开始拖动
                Log.d("DragDropTest", "开始拖动");
                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                //进入目标区域
                Log.d("DragDropTest", "进入目标区域");
                break;

            case DragEvent.ACTION_DRAG_LOCATION:
                //在目标区域移动
                Log.d("DragDropTest", "在目标区域移动：drag_loaction x=" +event.getX() + ", y=" +event.getY());
                break;

            case DragEvent.ACTION_DRAG_EXITED:
                //离开目标区域
                Log.d("DragDropTest", "离开目标区域");
                break;

            case DragEvent.ACTION_DROP:
                //在目标区域放下ImageView控件
                Log.d("DragDropTest", "在目标区域放下ImageView控件");
                //创建一个新的ImageView控件
                ImageView imageView1 = (ImageView)getLayoutInflater().inflate(R.layout.dragdrop_image, null);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = (int)(event.getX());
                layoutParams.topMargin = (int)(event.getY());
                //将ImageView控件添加到Famelayout中，完成一次复制
                frameLayoutDragDrop.addView(imageView1, layoutParams);
                break;

            case DragEvent.ACTION_DRAG_ENDED:
                Log.d("DragDropTest", "放下ImageView控件");
                break;

            default:
                return false;
        }

        return true;
    }
}
