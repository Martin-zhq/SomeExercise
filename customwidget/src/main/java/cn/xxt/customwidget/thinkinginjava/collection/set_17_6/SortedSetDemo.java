package cn.xxt.customwidget.thinkinginjava.collection.set_17_6;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Author zhq
 * @Date 2019-11-07-10:59
 * @Description
 * @Email 1457453696@qq.com
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        System.out.println(sortedSet);

        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);

        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                low = it.next();
            }
            if (i == 6) {
                high = it.next();
            } else {
                it.next();
            }
        }

        System.out.println(low);
        System.out.println(high);
        System.out.println(((TreeSet<String>) sortedSet).subSet(low, high));
        System.out.println(((TreeSet<String>) sortedSet).tailSet(low));
    }
}
