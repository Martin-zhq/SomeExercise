package cn.xxt.designpattern.singletonpattern;
/**
 * 单例
 * @author zhq
 * @date 2018/10/12 下午2:46
 */
public class SingletonClass {

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        return SingleHolder.singletonClass;
    }

    private static class SingleHolder {
        private static SingletonClass singletonClass = new SingletonClass();
    }

}
