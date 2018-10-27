package cn.xxt.designpattern.simplefactorypattern;
/**
 * 工厂类，主要封装创建不同产品实例的逻辑
 * @author zhq
 * @date 2018/10/12 上午10:37
 */
public class Factory {

    public Product createProduct(String proName) {
        Product product = null;

        if ("A".equals(proName)) {
            product = new ConcreateProductA();
        } else if ("B".equals(proName)) {
            product = new ConcreateProductB();
        }

        return product;
    }
}
