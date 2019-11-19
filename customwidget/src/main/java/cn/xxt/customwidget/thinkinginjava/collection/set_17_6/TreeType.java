package cn.xxt.customwidget.thinkinginjava.collection.set_17_6;

import android.support.annotation.NonNull;

/**
 * @Author zhq
 * @Date 2019-11-07-10:05
 * @Description
 * @Email 1457453696@qq.com
 */
public class TreeType extends SetType implements Comparable<TreeType>{

    public TreeType(int n) {
        super(n);
    }

    @Override
    public int compareTo(@NonNull TreeType o) {
        return (o.i < i ? -1 : (o.i == i ? 0 : 1));
    }
}
