package cn.xxt.designpattern.abstractfactory;

public class AbstractFactroyTest {

    public static void main(String[] args) {
        System.out.println("---------------");
        //工厂A
        AbstractFactory factoryA = new FactoryA();
        factoryA.createHat().hatMethod();
        factoryA.createShirt().shirtMethod();

        System.out.println(">>>>>>>>>>>>>>>");

        //工厂B
        AbstractFactory factoryB = new FactoryB();
        factoryB.createHat().hatMethod();
        factoryB.createShirt().shirtMethod();

        System.out.println("---------------");
    }
}
