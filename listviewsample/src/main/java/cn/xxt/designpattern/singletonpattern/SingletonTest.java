package cn.xxt.designpattern.singletonpattern;

public class SingletonTest {

    public static void main(String[] args) {
        //实例化对象
//        SingletonClass singletonClass = SingletonClass.getInstance();
//        System.out.println(singletonClass.toString());
//
//        System.out.println(">>>>>>>>>>>>>>>>>>");
//
//        SingletonClass singletonClass1 = SingletonClass.getInstance();
//        System.out.println(singletonClass1.toString());

        StoreHouse storeHouse1 = StoreHouse.getInstance();
        StoreHouse storeHouse2 = StoreHouse.getInstance();
        Carrier carrier1 = new Carrier(storeHouse1);
        Carrier carrier2 = new Carrier(storeHouse2);

        System.out.println("二者是不是相同的仓库？");
        System.out.println(storeHouse1.equals(storeHouse2) ? "是" : "不是");
        carrier1.moveIn(100);
        System.out.println("仓库剩余量：" + carrier1.storeHouse.getQuntatity());
        carrier2.moveOut(22);
        System.out.println("仓库剩余量：" + carrier2.storeHouse.getQuntatity());
    }
}
