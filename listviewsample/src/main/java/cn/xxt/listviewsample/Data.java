package cn.xxt.listviewsample;

public class Data {

    private int imgId;

    private String title;

    private String content;

    public Data() {

    }

    public Data(int imgId, String title, String content) {
        this.imgId = imgId;
        this.title = title;
        this.content = content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
