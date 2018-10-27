package cn.xxt.designpattern.surfacepattern;

public class Client {

    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone();

        mobilePhone.dial();
        mobilePhone.hangUp();

        mobilePhone.videoChat();
        mobilePhone.hangUp();
    }
}
