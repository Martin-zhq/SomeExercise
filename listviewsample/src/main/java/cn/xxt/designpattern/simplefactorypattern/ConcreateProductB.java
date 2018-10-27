package cn.xxt.designpattern.simplefactorypattern;
/**
 * 产品B
 * @author zhq
 * @date 2018/10/12 上午10:54
 */
public class ConcreateProductB extends Product {

    @Override
    protected void comMethod() {
        System.out.println("生产产品B");
    }
}
