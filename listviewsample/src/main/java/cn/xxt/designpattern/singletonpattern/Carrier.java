package cn.xxt.designpattern.singletonpattern;

/**
 * @Author zhq
 * @Date 2019-06-19-11:36
 * @Description
 * @Email 1457453696@qq.com
 */
public class Carrier {
    public StoreHouse storeHouse;

    public Carrier(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    public void moveIn(int i) {
        this.storeHouse.setQuntatity(this.storeHouse.getQuntatity() + i);
    }

    public void moveOut(int i) {
        this.storeHouse.setQuntatity(this.storeHouse.getQuntatity() - i);
    }
}
