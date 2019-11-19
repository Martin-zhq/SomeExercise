package cn.xxt.customwidget.thinkinginjava.collection.set_17_6;

/**
 * @Author zhq
 * @Date 2019-11-07-10:00
 * @Description
 * @Email 1457453696@qq.com
 */
public class SetType {

    int i;

    public SetType(int n) {
        i = n;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i == ((SetType) obj).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
