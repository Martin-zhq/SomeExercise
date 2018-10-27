package cn.xxt.designpattern.betterfactorypattern;

public class TFactroyTest {

    public static void main(String[] args) {
        //生成Product类产品的工厂
        AbstractFactory<Product> factory = new ConCreateAbstractFactoryA<>();
        //生产出ProductA
        Product productA = factory.createProduct(ProductA.class);
        productA.method();

        //生成OtherProduct类产品的工厂
        AbstractFactory<OtherProduct> otherProductFactory = new ConCreateAbstractFactoryA<>();
        //生产出OtherProduct
        OtherProductB productB = otherProductFactory.createProduct(OtherProductB.class);
        productB.otherMethod();
    }
}
