package cn.xxt.designpattern.abstractfactory;

public class FactoryA extends AbstractFactory {

    @Override
    public HatProduct createHat() {
        return new RedHat();
    }

    @Override
    public ShirtProduct createShirt() {
        return new RedShirt();
    }
}
