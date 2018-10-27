package cn.xxt.designpattern.betterfactorypattern;
/**
 * 通过定义抽象的产品E，传入具体产品T的class来实现实例化具体产品
 * @author zhq
 * @date 2018/10/12 下午2:11
 */
public class ConCreateAbstractFactoryA<E> extends AbstractFactory<E> {

    @Override
    public <T extends E> T createProduct(Class<T> clz) {
        E e = null;
        try {
            //通过反射得来的具体类的实例
            e = (E) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }

        return (T)e;
    }
}
