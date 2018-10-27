package cn.xxt.designpattern.factorypattern;

public class FactoryA extends AbFactory{
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
