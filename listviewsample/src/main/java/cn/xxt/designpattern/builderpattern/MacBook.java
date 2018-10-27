package cn.xxt.designpattern.builderpattern;
/**
 * 具体的对象，继承自AbstractComputer
 * @author zhq
 * @date 2018/10/12 上午10:07
 */
public class MacBook extends AbstractComputer {

    /**
     * 将构造器权限设为包权限
     */
    protected MacBook() {

    }

    /**
     * 对系统属性进行重写
     */
    @Override
    public void setmOs() {
        mOs = "Mac OS x 111";
    }
}
