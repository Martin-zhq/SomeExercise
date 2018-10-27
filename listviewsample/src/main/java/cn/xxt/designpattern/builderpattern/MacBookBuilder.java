package cn.xxt.designpattern.builderpattern;
/**
 * 继承自Builder的具体的MacBookBuilder
 * @author zhq
 * @date 2018/10/12 上午10:16
 */
public class MacBookBuilder extends Builder {

    private AbstractComputer mAbstractComputer = new MacBook();

    @Override
    public AbstractComputer create() {
        return mAbstractComputer;
    }

    @Override
    public Builder buildBoard(String board) {
        mAbstractComputer.setmBoard(board);
        return this;
    }

    @Override
    public Builder buildDisplay(String display) {
        mAbstractComputer.setmDisplay(display);
        return this;
    }

    @Override
    public Builder buildOs() {
        mAbstractComputer.setmOs();
        return this;
    }
}
