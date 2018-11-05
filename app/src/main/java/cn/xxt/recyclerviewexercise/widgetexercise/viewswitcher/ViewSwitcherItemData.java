package cn.xxt.recyclerviewexercise.widgetexercise.viewswitcher;

public class ViewSwitcherItemData {

    private String name;

    private int ivIcon;

    public ViewSwitcherItemData(String name, int ivIcon) {
        this.name = name;
        this.ivIcon = ivIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIvIcon() {
        return ivIcon;
    }

    public void setIvIcon(int ivIcon) {
        this.ivIcon = ivIcon;
    }
}
