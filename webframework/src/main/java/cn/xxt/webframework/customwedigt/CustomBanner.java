package cn.xxt.webframework.customwedigt;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.xxt.webframework.DensityUtil;
import cn.xxt.webframework.R;

/**
 * 结合工程中已有的SlideShowView和任教主的banner糅合出来的轮播图控件
 * 任教主banner地址：https://github.com/singwhatiwanna/banner
 * @author zhq
 * @date 2018/11/22 下午7:08
 */
public class CustomBanner extends FrameLayout {

    private static final int TIME_INTERVAL = 4;

    private static final int FAKE_BANNER_SIZE = 100;

    private ArrayList<String> imageUrls;

    private int imageCount;

    private ViewPager viewPager;

    private ScheduledExecutorService scheduledExecutorService;

    private Context context;

    private boolean isUserTouched;

    private int currentPosition = 0;

    private CustomBannerAdapter customBannerAdapter;

    private onClickImageListener onClickImageListener;

    /** handler的作用，切换到主线程：因为handler会将线程切换到它所在的线程中 */
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (FAKE_BANNER_SIZE - 1 == currentPosition) {
                viewPager.setCurrentItem(imageCount - 1, false);
            } else {
                viewPager.setCurrentItem(currentPosition);
            }
        }
    };


    public CustomBanner(Context context) {
        this(context, null);
    }

    public CustomBanner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public CustomBanner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.custom_banner, this, true);
    }

    /**
     * 停止轮播
     */
    private void stopPlay() {
        if (null != scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }
    }

    private void startPlay() {
        stopPlay();
//        scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().
//                setNameFormat("custom-banner-pool-%d").build());
        scheduledExecutorService.scheduleAtFixedRate(new CustomBannerTask(), 1, TIME_INTERVAL,
                TimeUnit.SECONDS);
    }

    private class CustomBannerTask implements Runnable {
        @Override
        public void run() {
            if (!isUserTouched) {
                currentPosition = (currentPosition + 1) % FAKE_BANNER_SIZE;
                handler.obtainMessage().sendToTarget();
            }
        }
    }


    private void initUI() {
        if (null == imageUrls || imageUrls.size() == 0) {
            return;
        }

        imageCount = imageUrls.size();

        viewPager = findViewById(R.id.view_pager);
        viewPager.setFocusable(true);
        //设置viewPager中每一页之间的边距

        viewPager.setPageMargin(DensityUtil.dip2px(context, 8));

        customBannerAdapter = new CustomBannerAdapter(context);
        viewPager.setAdapter(customBannerAdapter);
        viewPager.setOnPageChangeListener(customBannerAdapter);
        viewPager.setOffscreenPageLimit(imageUrls.size());
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN
                        || action == MotionEvent.ACTION_MOVE) {
                    isUserTouched = true;
                } else {
                    isUserTouched = false;
                }

                return false;
            }
        });
    }

    private class CustomBannerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

        private LayoutInflater inflater;

        public CustomBannerAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return FAKE_BANNER_SIZE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            position %= imageCount;
            View view = inflater.inflate(R.layout.item_custom_banner, container, false);
            ImageView imageView = view.findViewById(R.id.image_view);
            //加载图片
            Picasso.with(context).load(imageUrls.get(position))
                    .placeholder(R.drawable.bg_placeholder_loading)
                    .error(R.drawable.bg_placeholder_load_fail)
                    .fit()
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .config(Bitmap.Config.RGB_565)
                    .into(imageView);

            final int pos = position;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != onClickImageListener) {
                        onClickImageListener.onClickImage(pos);
                    }
                }
            });

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public void finishUpdate(@NonNull ViewGroup container) {
            int position = viewPager.getCurrentItem();

            // TODO: 2018/11/22 特殊情况，得考虑
            if (0 == position) {
                position = imageCount;
                viewPager.setCurrentItem(position, false);
            } else if (FAKE_BANNER_SIZE - 1 ==position) {
                position = imageCount - 1;
                viewPager.setCurrentItem(position, false);
            }
        }

        /** onPageChangeListener中的方法 */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //do nothing
        }

        @Override
        public void onPageSelected(int position) {
            currentPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            //do nothing
        }
    }

    public void setOnClickImageListener(onClickImageListener onClickImageListener) {
        this.onClickImageListener = onClickImageListener;
    }

    public interface onClickImageListener {
        void onClickImage(int pos);
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
        initUI();
        startPlay();
    }

}
