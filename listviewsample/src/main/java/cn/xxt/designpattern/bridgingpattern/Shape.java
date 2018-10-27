package cn.xxt.designpattern.bridgingpattern;

public class Shape extends BaseShape {

    private int x;
    private int y;
    private int radius;

    public Shape(BaseCircle baseCircle, int x, int y, int radius) {
       super(baseCircle);
       this.x = x;
       this.y = y;
       this.radius =radius;
    }


    @Override
    public void draw() {
        baseCircle.drawCircle(radius, x, y);
    }
}
