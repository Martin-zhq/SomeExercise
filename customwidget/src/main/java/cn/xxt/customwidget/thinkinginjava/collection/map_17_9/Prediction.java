package cn.xxt.customwidget.thinkinginjava.collection.map_17_9;

import java.util.Random;

/**
 * @Author zhq
 * @Date 2019-11-11-09:22
 * @Description
 * @Email 1457453696@qq.com
 */
public class Prediction {

    private static Random random = new Random(47);

    private boolean shadow = random.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter";
        } else {
            return "Early spring";
        }
    }

}
