package cn.xxt.designpattern.proptypepattern;

import java.util.ArrayList;

public class WordDocument implements Cloneable {

    /**
     * 文字描述
     */
    private String mText;

    /**
     * 图片地址集合
     */
    private ArrayList<String> images = new ArrayList<>();

    public WordDocument() {
        System.out.println("WordDocument构造器");
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void addImages(String imageUrl) {
        this.images.add(imageUrl);
    }

    @Override
    protected WordDocument clone() {
        try {
            WordDocument wordDocument = (WordDocument) super.clone();
            wordDocument.mText = this.mText;
            wordDocument.images = (ArrayList<String>) this.images.clone();
            return wordDocument;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void showWordDocument() {
        System.out.println("<<<<<<<<<WordDocument Start>>>>>>>>>>");
        System.out.println("mText: " + mText);
        System.out.println("ImagesList:");
        for (String imageUrl : images) {
            System.out.println(imageUrl);
        }
        System.out.println("<<<<<<<<<WordDocument End>>>>>>>>>>");
    }

}
