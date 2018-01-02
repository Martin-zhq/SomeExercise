package cn.xxt.recyclerviewexercise.widgetexercise;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RemoteViews;

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
     * 显示带有信息的notification
     * @param view
     */
    public void clickBtnWithInfoNotify(View view) {
        //在Notification的右下角显示信息
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.face1).setContentTitle("info")
                .setContentText("文本信息显示在右下角").setContentInfo("信息");
        notificationManager.notify(4, builder.build());
        //在Notification的右下角显示数字（信息的特殊形式）
        Notification.Builder builder1 = new Notification.Builder(this)
                .setSmallIcon(R.drawable.face2).setContentTitle("Number")
                .setContentText("数字显示在右下角").setNumber(25);
        notificationManager.notify(5, builder1.build());

    }

    /**
     * 显示进度条的notification
     * @param view
     */
    public void clickBtnWithProgressNotify(View view) {
        //显示确定的进度条，setProgress()方法的第三个参数必须为false
        //其第一个参数表示进度最大值，第二个参数表示当前值
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.face3).setContentTitle("determinate progress")
                .setContentText("显示进度的进度条").setProgress(100, 25, false);
        notificationManager.notify(6, builder.build());

        //显示不确定进度的进度条 第三个参数必须为true
        Notification.Builder builder1 = new Notification.Builder(this)
                .setSmallIcon(R.drawable.face4).setContentTitle("Indeterminate progress")
                .setContentText("不确定进度的进度条").setProgress(100, 25, true);
        notificationManager.notify(7, builder1.build());

    }

    /**
     * 永久存在的notification
     * @param view
     */
    public void clickBtnPermanentNotify(View view) {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.face5).setContentTitle("短信内容")
                .setOngoing(true).setContentText("贼他么6");
        notificationManager.notify(8, builder.build());
    }

    /**
     * 自定义的notification setContent方法，关键是remoteview。
     * @param view
     */
    public void clickBtnCustomNotify(View view) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification_layout);
        //设置布局中TextView显示的文本
        remoteViews.setTextViewText(R.id.tv_custom, "更新显示的自定义文本");
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.face5).setContent(remoteViews);
        notificationManager.notify(9, builder.build());
    }

    public void clickBtnClearAllNotify(View view) {
        notificationManager.cancelAll();
    }

}
