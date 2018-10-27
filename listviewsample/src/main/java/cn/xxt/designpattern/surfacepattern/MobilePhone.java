package cn.xxt.designpattern.surfacepattern;
/**
 * 这个类就是门面角色；这个门面设计模式，感觉就是个简单的调用
 * @author zhq
 * @date 2018/10/27 上午9:35
 */
public class MobilePhone {

    private Camera camera = new Camera();
    private Phone phone = new Phone();

    public void dial() {
        phone.dial();
    }

    public void hangUp() {
        phone.hangUp();
    }

    /**
     * 视频聊天
     */
    public void videoChat() {
        camera.open();
        phone.dial();
    }

    public void takePhotos() {
        camera.open();
        camera.takePhoto();
    }

    public void closeCamera() {
        camera.close();
    }

    public void fastCamera() {
        camera.open();
        camera.takePhoto();
        camera.close();
    }
}
