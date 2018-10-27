package cn.xxt.designpattern.builderpattern;
/**
 * 产生对象，并对产生的对象进行赋值
 * @author zhq
 * @date 2018/10/12 上午10:11
 */
public abstract class Builder {

    /**
     * 创建需要的对象
     * @return
     */
    public abstract AbstractComputer create();

    /**
     * 对产生的AbstractComputer赋值
     * @param board
     * @return
     */
    public abstract Builder buildBoard(String board);

    public abstract Builder buildDisplay(String display);

    public abstract Builder buildOs();
}
