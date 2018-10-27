package cn.xxt.designpattern.surfacepattern;

public class Phone implements ImpPhone {

    protected Phone() {

    }

    @Override
    public void dial() {
        System.out.println("拨打电话");
    }

    @Override
    public void hangUp() {
        System.out.println("挂断电话");
    }
}
