package cn.xxt.customwidget.thinkinginjava.collection.method17_11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @Author zhq
 * @Date 2019-11-22-10:30
 * @Description
 * @Email 1457453696@qq.com
 */
public class FailFast {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try {
            String s = it.next();
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
}
