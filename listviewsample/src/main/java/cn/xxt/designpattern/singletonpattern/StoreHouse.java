package cn.xxt.designpattern.singletonpattern;

/**
 * @Author zhq
 * @Date 2019-06-19-11:36
 * @Description
 * @Email 1457453696@qq.com
 */
public class StoreHouse {

//    private static StoreHouse storeHouse = new StoreHouse();
//    /** 单例方式1 */
//
//    public static StoreHouse getInstance() {
//        return storeHouse;
//    }

    private static StoreHouse storeHouse = null;

    /**
     * 改进的懒汉式单例模式
     * @return
     */
    public static StoreHouse getInstance() {

        if (null == storeHouse) {
            synchronized (StoreHouse.class) {
                if (null == storeHouse) {
                    storeHouse = new StoreHouse();
                }
            }
        }

        return storeHouse;
    }

    private StoreHouse() {

    }

    private int quntatity = 100;

    public int getQuntatity() {
        return quntatity;
    }

    public void setQuntatity(int quntatity) {
        this.quntatity = quntatity;
    }

    private static class StoreHouse1 {
        private static StoreHouse storeHouse = new StoreHouse();
    }

    public static StoreHouse getInstance1() {
        return StoreHouse1.storeHouse;
    }
}
