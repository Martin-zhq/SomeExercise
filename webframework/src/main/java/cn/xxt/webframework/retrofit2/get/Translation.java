package cn.xxt.webframework.retrofit2.get;

public class Translation {

    private int status;

    private Content content;

    private class Content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    public void showData() {
        System.out.println(status);

        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);
    }
}
