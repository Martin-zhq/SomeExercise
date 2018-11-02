package cn.xxt.webframework.retrofit2.post;

import java.util.List;

/**
 * 根据 有道翻译的接口返回结果抽象出的实体类
 * @author zhq
 * @date 2018/10/29 下午3:25
 */
public class Translation {

    private String type;

    private int errorCode;

    private int elapsedTime;

    private List<List<TranslateResultBean>> translateResultBeanList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public List<List<TranslateResultBean>> getTranslateResultBeanList() {
        return translateResultBeanList;
    }

    public void setTranslateResultBeanList(List<List<TranslateResultBean>> translateResultBeanList) {
        this.translateResultBeanList = translateResultBeanList;
    }

    public static class TranslateResultBean {

        public String src;

        public String tgt;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getTgt() {
            return tgt;
        }

        public void setTgt(String tgt) {
            this.tgt = tgt;
        }
    }
}
