package cn.xxt.designpattern.bridgingpattern;

public class TestBridingPattern {

    public static void main(String[] args) {
        BaseShape redCircle = new Shape(new RedCircle(), 0, 0, 22);
        BaseShape blueCircle = new Shape(new BlueCircle(), 55, 66, 77);

        System.out.println("*****************");
        redCircle.draw();
        System.out.println(">>>>>>>>>>>>>>>>>");
        blueCircle.draw();
        System.out.println("*****************");
    }
}
