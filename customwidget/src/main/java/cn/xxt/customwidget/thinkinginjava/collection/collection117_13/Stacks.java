package cn.xxt.customwidget.thinkinginjava.collection.collection117_13;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author zhq
 * @Date 2019-11-22-14:35
 * @Description
 * @Email 1457453696@qq.com
 */
public class Stacks {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (Month m : Month.values()) {
            stack.push(m.toString());
        }
        System.out.println("stack = " + stack);

        stack.addElement("The last line");
        System.out.println("element 5 = " + stack.elementAt(5));
        System.out.println("popping elements:");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values()) {
            lstack.addFirst(m.toString());
        }
        System.out.println("lstack = " + lstack);
        while (!lstack.isEmpty()) {
            System.out.println(lstack.removeFirst() + " ");
        }
    }
}
