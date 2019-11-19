package cn.xxt.customwidget.thinkinginjava.collection.map_17_9;

import android.support.annotation.NonNull;

/**
 * @Author zhq
 * @Date 2019-11-19-14:47
 * @Description
 * @Email 1457453696@qq.com
 */
public class Individual implements Comparable<Individual> {

    private static long counter = 0;

    private final long id = counter++;

    private String name;

    public Individual(String name) {
        this.name = name;
    }

    public Individual() {

    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (null == name ? "" : " " + name);
    }

    public long id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Individual && id == ((Individual)obj).id;
    }

    @Override
    public int hashCode() {
        int result  = 17;
        if (null != name) {
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + (int)id;
        return result;
    }

    @Override
    public int compareTo(@NonNull Individual o) {
        String first = getClass().getSimpleName();
        String oFirst = o.getClass().getSimpleName();
        int firstCompare = first.compareTo(oFirst);
        if (0 != firstCompare) {
            return firstCompare;
        }
        if (name != null && o.name != null) {
            int secondCompare = name.compareTo(o.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }

        return o.id < id ? -1 : (o.id == id ? 0 : 1);
    }
}
