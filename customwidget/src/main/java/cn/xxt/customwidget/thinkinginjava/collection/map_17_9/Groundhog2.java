package cn.xxt.customwidget.thinkinginjava.collection.map_17_9;

/**
 * @Author zhq
 * @Date 2019-11-11-09:37
 * @Description
 * @Email 1457453696@qq.com
 */
public class Groundhog2 extends Groundhog {

    public Groundhog2(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Groundhog2 && (number == ((Groundhog2) obj).number);
    }
}
