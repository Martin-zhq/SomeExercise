package cn.xxt.designpattern.factorypattern;
/**
 * 工厂模式测试类
 * @author zhq
 * @date 2018/10/12 上午11:53
 */
public class FactoryPatternTest {

    public static void main(String[] args) {
        AbFactory factoryA = new FactoryA();
        Product productA = factoryA.createProduct();
        productA.method();

        AbFactory factoryB = new FactoryB();
        Product productB = factoryB.createProduct();
        productB.method();
    }
}
