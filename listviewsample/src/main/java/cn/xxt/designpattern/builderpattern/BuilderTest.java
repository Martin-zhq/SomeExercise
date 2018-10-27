package cn.xxt.designpattern.builderpattern;

public class BuilderTest {

    public static void main(String[] args) {
        Builder builder = new MacBookBuilder();
        builder.buildBoard("苹果")
                .buildDisplay("三星")
                .buildOs();
        AbstractComputer abstractComputer = builder.create();
        System.out.println(abstractComputer.toString());
    }
}
