package cn.xxt.designpattern.surfacepattern;

public class Camera implements ImpCamera {

    protected Camera() {

    }


    @Override
    public void open() {
        System.out.println("打开摄像头");
    }

    @Override
    public void takePhoto() {
        System.out.println("拍照中");
    }

    @Override
    public void close() {
        System.out.println("关闭摄像头");
    }
}
