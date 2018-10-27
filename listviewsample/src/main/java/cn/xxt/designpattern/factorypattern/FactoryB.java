package cn.xxt.designpattern.factorypattern;

public class FactoryB extends AbFactory {

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
