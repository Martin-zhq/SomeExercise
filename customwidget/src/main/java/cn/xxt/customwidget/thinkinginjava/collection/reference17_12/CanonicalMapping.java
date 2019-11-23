package cn.xxt.customwidget.thinkinginjava.collection.reference17_12;

import java.util.WeakHashMap;

/**
 * @Author zhq
 * @Date 2019-11-22-11:56
 * @Description
 * @Email 1457453696@qq.com
 */
public class CanonicalMapping {

    public static void main(String[] args) {
        int size = 1000;
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i  = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = k;
            }
            map.put(k, v);
        }
        System.gc();
    }
}
