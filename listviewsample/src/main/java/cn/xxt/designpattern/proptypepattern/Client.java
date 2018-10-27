package cn.xxt.designpattern.proptypepattern;

public class Client {

    public void cloneDocument() {
        System.out.println(">>>>>>>原型对象《《《《《《");
        WordDocument wordDocument = new WordDocument();
        wordDocument.setmText("是是是");
        wordDocument.addImages("gaga1.jpg");
        wordDocument.addImages("gaga2.jpg");
        wordDocument.showWordDocument();
        System.out.println(">>>>>>>>>>>>克隆对象>>>>>>>>>>>>");
        WordDocument wordDocumentClone = wordDocument.clone();
        wordDocumentClone.addImages("gaga3.jpg");
        wordDocumentClone.showWordDocument();
    }
}
