package cn.xxt.designpattern.betterfactorypattern;
/**
 * Product类型产品的具体产品
 * @author zhq
 * @date 2018/10/12 下午2:13
 */
public class ProductA extends Product {
    @Override
    public void method() {
        System.out.println("method:" + "this is ProductA");
    }
}
