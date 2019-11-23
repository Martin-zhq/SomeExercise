package cn.xxt.customwidget.thinkinginjava.io.file18_1;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author zhq
 * @Date 2019-11-22-17:19
 * @Description
 * @Email 1457453696@qq.com
 */
public class PPrint {

    public static String pformat(Collection<?> c) {
        if (c.size() == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        for (Object elem : c) {
            if (c.size() != 1) {
                result.append("\n ");
            }
            result.append(elem);
        }
        if (c.size() != 1) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}
