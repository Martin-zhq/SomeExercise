package cn.xxt.customwidget.thinkinginjava.collection.method17_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author zhq
 * @Date 2019-11-22-09:56
 * @Description
 * @Email 1457453696@qq.com
 */
public class ReadOnly {

    static Collection<String> data = new ArrayList<>(Arrays.asList("one two three four five".split(" ")));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c);
//        c.add("six");

        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next());
//        lit.add("six");

        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        System.out.println(s);
//        s.add("six");

        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));
        System.out.println(ss);

        Map<String, String> m = Collections.unmodifiableMap(new HashMap<String, String>());
        System.out.println(m);
//        m.put("1", "1");
    }
}
