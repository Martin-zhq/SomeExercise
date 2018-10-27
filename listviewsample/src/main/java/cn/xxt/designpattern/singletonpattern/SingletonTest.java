package cn.xxt.designpattern.singletonpattern;

public class SingletonTest {

    public static void main(String[] args) {
        //实例化对象
        SingletonClass singletonClass = SingletonClass.getInstance();
        System.out.println(singletonClass.toString());

        System.out.println(">>>>>>>>>>>>>>>>>>");

        SingletonClass singletonClass1 = SingletonClass.getInstance();
        System.out.println(singletonClass1.toString());
    }
}
