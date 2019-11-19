package cn.xxt.customwidget.thinkinginjava.collection.map_17_9;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhq
 * @Date 2019-11-11-09:24
 * @Description
 * @Email 1457453696@qq.com
 */
public class SpringDectector {

    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.print(map);
        System.out.println();

        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        if (map.containsKey(gh)) {
            System.out.println(map.get(gh));
        } else {
            System.out.println("Key not found: " +gh);
        }
    }

    public static void main(String[] args) throws Exception{
        detectSpring(Groundhog.class);
    }
}
