package cn.xxt.designpattern.bridgingpattern;

public abstract class BaseShape {
    protected BaseCircle baseCircle;

    protected BaseShape(BaseCircle baseCircle) {
        this.baseCircle = baseCircle;
    }

    public abstract void draw();
}
