package cn.xxt.designpattern.abstractfactory;

public class FactoryB extends AbstractFactory {

    @Override
    public HatProduct createHat() {
        return new WhiteHat();
    }

    @Override
    public ShirtProduct createShirt() {
        return new whiteShirt();
    }
}
