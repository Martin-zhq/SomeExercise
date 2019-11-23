package cn.xxt.customwidget.thinkinginjava.collection.test17_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author zhq
 * @Date 2019-11-21-15:18
 * @Description
 * @Email 1457453696@qq.com
 */
public class SetPerformance {

    static List<Test<Set<Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Set<Integer>>("add") {
            @Override
            int test(Set<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0;j < size; j++) {
                        container.add(j);
                    }
                }
                return loops * size;
            }
        });

        tests.add(new Test<Set<Integer>>("contains") {
            @Override
            int test(Set<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        container.contains(j);
                    }
                }

                return loops * span;
            }
        });

        tests.add(new Test<Set<Integer>>("iterate") {
            @Override
            int test(Set<Integer> container, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Integer> it = container.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }

                return loops * container.size();
            }
        });
    }


    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }

        Tester.filedWidth = 10;
        Tester.run(new TreeSet<Integer>(), tests);
        Tester.run(new HashSet<Integer>(), tests);
        Tester.run(new LinkedHashSet<Integer>(), tests);
    }
}
