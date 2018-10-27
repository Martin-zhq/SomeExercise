package cn.xxt.audiorecord;

import android.content.Context;
import android.content.res.Resources;

import cn.xxt.listviewsample.R;

/**
 * 自定义错误码
 * @author zhq
 * @date 2018/10/9 下午2:58
 */
public class ErrorCode {

    public final static int SUCCESS = 1000;
    public final static int E_NOSDCARD = 1001;
    public final static int E_STATE_RECODING = 1002;
    public final static int E_UNKOWN = 1003;


    public static String getErrorInfo(Context vContext, int vType) throws Resources.NotFoundException {
        switch(vType)
        {
            case SUCCESS:
                return "success";
            case E_NOSDCARD:
                return vContext.getResources().getString(R.string.error_no_sdcard);
            case E_STATE_RECODING:
                return vContext.getResources().getString(R.string.error_state_record);
            case E_UNKOWN:
            default:
                return vContext.getResources().getString(R.string.error_unknown);
        }
    }
}
