package cn.xxt.customwidget.thinkinginjava.collection.set17_7;

/**
 * @Author zhq
 * @Date 2019-11-07-14:20
 * @Description
 * @Email 1457453696@qq.com
 */
public class DequeTest {

    static void fillTest(Deque<Integer> deque) {
        for (int i = 15; i < 20; i++) {
            deque.addFirst(i);
        }

        for (int i = 30; i < 35; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        fillTest(deque);
        System.out.println(deque);

        while (deque.size() != 0) {
            System.out.print(deque.removeFirst() + " ");
        }
        System.out.println();
        fillTest(deque);
        while (deque.size() != 0) {
            System.out.print(deque.removeLast() + " ");
        }
    }
}
