package cn.xxt.customwidget.thinkinginjava.collection.set17_7;

import java.util.LinkedList;

/**
 * @Author zhq
 * @Date 2019-11-07-14:15
 * @Description
 * @Email 1457453696@qq.com
 */
public class Deque<T> {

    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T e) {
        deque.addFirst(e);
    }

    public void addLast(T e) {
        deque.addLast(e);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
