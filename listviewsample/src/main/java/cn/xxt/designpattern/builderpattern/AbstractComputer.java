package cn.xxt.designpattern.builderpattern;
/**
 * 抽象的电脑，将其系统抽象出来，可以在子类中重写。
 * @author zhq
 * @date 2018/10/12 上午10:01
 */
public abstract class AbstractComputer {

    /** 主板 显示器  操作系统 */
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;

    protected AbstractComputer() {

    }

    public String getmBoard() {
        return mBoard;
    }

    public void setmBoard(String mBoard) {
        this.mBoard = mBoard;
    }

    public String getmDisplay() {
        return mDisplay;
    }

    public void setmDisplay(String mDisplay) {
        this.mDisplay = mDisplay;
    }

    /**
     * 抽离出一个抽象方法用于设置mOs属性
     */
    public abstract void setmOs();

    @Override
    public String toString() {
        return "AbstractComputer {" +
                " mBoard = '" + mBoard + "'" +
                ", mDisplay = '" + mDisplay + "'" +
                ", mOs = '" + mOs + "'" + "}";
    }
}
