package cn.xxt.customwidget.thinkinginjava.collection.set17_7;

import android.support.annotation.NonNull;

import java.util.PriorityQueue;

/**
 * @Author zhq
 * @Date 2019-11-07-11:27
 * @Description 优先级队列
 * @Email 1457453696@qq.com
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(String td, char pi, int sec) {
            primary = pi;
            secondary = sec;
            item = td;
        }

        @Override
        public int compareTo(@NonNull ToDoItem o) {
            if (primary > o.primary) {
                return +1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return +1;
                } else if (secondary == o.secondary) {
                    return 0;
                }
            }

            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": " +item;
        }
    }


    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(td, pri, sec));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty crash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn", 'A', 1);
        toDoList.add("Feed cat", 'B', 1);

        while (!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }
    }
}
