package cn.xxt.designpattern.bridgingpattern;

public class RedCircle implements BaseCircle {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("绘制红色的圆");
        System.out.println("半径：" + radius);
        System.out.println("圆心坐标：" + "x:" + x + ", y:" + y);
    }
}
