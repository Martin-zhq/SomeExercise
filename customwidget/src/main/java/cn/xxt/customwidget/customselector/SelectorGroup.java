package cn.xxt.customwidget.customselector;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhq
 * @Date 2019/2/19-上午11:35
 * @Description
 * @Email 1457453696@qq.com
 */
public class SelectorGroup {
    private Set<Selector> selectors = new HashSet<>();

    public void addSelector(Selector selector) {
        selectors.add(selector);
    }

    public void setSelected(String mark) {
        for (Selector selector : selectors) {
            if (selector.getMark().equals(mark)) {
                selector.switchSelector();
            }
        }
    }

    public void setSelected(Selector selector) {
        cancelPreSelector(selector);
    }

    private void cancelPreSelector(Selector selector) {
        for (Selector selector1 : selectors) {
            if (!selector1.equals(selector) && selector1.isSelected()) {
                selector1.switchSelector();
            }
        }
    }

    public Selector getSelected() {
        for (Selector selector : selectors) {
            if (selector.isSelected()) {
                return selector;
            }
        }

        return null;
    }

    public void clear() {
        if (null != selectors) {
            selectors.clear();
        }
    }
}
