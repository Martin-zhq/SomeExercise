package cn.xxt.customwidget.thinkinginjava.collection.reference17_12;

/**
 * @Author zhq
 * @Date 2019-11-22-11:18
 * @Description
 * @Email 1457453696@qq.com
 */
public class Element {

    private String ident;

    public Element(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element && ident.equals(((Element)obj).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}
