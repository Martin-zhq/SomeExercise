package cn.xxt.customwidget.thinkinginjava.collection.reference17_12;

/**
 * @Author zhq
 * @Date 2019-11-22-10:42
 * @Description
 * @Email 1457453696@qq.com
 */
public class VeryBig {

    private static final int SIZE = 10000;
    private long[] lo = new long[SIZE];
    private String ident;
    public VeryBig(String id){
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() {
        System.out.println("Finalizing " + ident);
    }
}
