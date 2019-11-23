package cn.xxt.customwidget.thinkinginjava.collection.test17_10;

/**
 * @Author zhq
 * @Date 2019-11-21-10:05
 * @Description
 * @Email 1457453696@qq.com
 */
public abstract class Test<C> {

    String name;

    public Test(String name) {
        this.name = name;
    }

    abstract int test(C container, TestParam tp);
}
