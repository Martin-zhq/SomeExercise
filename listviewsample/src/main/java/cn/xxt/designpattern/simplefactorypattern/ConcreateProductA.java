package cn.xxt.designpattern.simplefactorypattern;
/**
 * A类产品
 * @author zhq
 * @date 2018/10/12 上午10:39
 */
public class ConcreateProductA extends Product{
    @Override
    protected void comMethod() {
        System.out.println("生产A类产品");
    }
}
