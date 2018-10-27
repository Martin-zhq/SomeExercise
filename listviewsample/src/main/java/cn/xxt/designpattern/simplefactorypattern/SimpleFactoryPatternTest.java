package cn.xxt.designpattern.simplefactorypattern;
/**
 * 简单工厂模式的测试类
 * @author zhq
 * @date 2018/10/12 上午11:27
 */
public class SimpleFactoryPatternTest {

    public static void main(String[] args) {
        Factory factory = new Factory();

        Product product = factory.createProduct("A");
        product.comMethod();
        product = factory.createProduct("B");
        product.comMethod();
    }
}
