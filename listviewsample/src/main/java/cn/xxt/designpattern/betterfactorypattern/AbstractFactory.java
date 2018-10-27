package cn.xxt.designpattern.betterfactorypattern;

public abstract class AbstractFactory<E> {

    /**
     *
     * @param clz 具体产品的class
     * @param <T> 具体产品
     * @return
     */
    public abstract <T extends E> T createProduct(Class<T> clz);
}
