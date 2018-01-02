package cn.xxt.recyclerviewexercise.widgetexercise;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xxt.recyclerviewexercise.R;
/**
 * notification练习
 * @author zhq
 * @date 2018/1/2 下午7:47
 */
public class NotificationActivity extends AppCompatActivity {

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    /**
     * 最普通的notification，只有标题、正文内容和左侧的一个图标
     * @param view
     */
    public void clickBtnCommonNotify(View view) {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.face4).setContentTitle("普通的notification示例")
                .setContentText("图标显示在左侧");
        notificationManager.notify(1, builder.build());
    }

    /**
     * 显示大图标的notification，包含标题，正文，大图标，小图标
     * @param view
     */
    public void clickBtnBigIconNotify(View view) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meizi);
        //如果设置了大图标，则大图标取代原来小图标的位置，原来的小图标会显示在右下角
        Notification.Builder builder = new Notification.Builder(this)
        .setSmallIcon(R.drawable.face1).setLargeIcon(bitmap)
                .setContentTitle("大图标的notification示例").setContentText("大图标放在左侧，小图标放在右下角。。");
        notificationManager.notify(2, builder.build());
    }

    /**
     * 显示大图的notification，大图是指任意尺寸的图像，所以notification可以显示任意尺寸的图像，但会受到
     * 手机本身硬件和android系统的限制。
     * @param view
     */
    public void clickBtnBigPictureNotify(View view) {
        //必须先清除大图notification，否则再次显示时会抛出异常
        notificationManager.cancel(3);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dragon);
        //调用bigPicture方法设置大图
        Notification notification = new Notification.BigPictureStyle(new Notification.Builder(this)
        .setContentTitle("大图片的notification").setContentText("大图").setSmallIcon(R.drawable.face1)).bigPicture(bitmap).build();
        notificationManager.notify(3, notification);
    }

    /**
     * 显示带有信息的
     * @param view
     */
    public void clickBtnWithInfoNotify(View view) {

    }

    public void clickBtnWithProgressNotify(View view) {

    }

    public void clickBtnClearAllNotify(View view) {

    }

}
