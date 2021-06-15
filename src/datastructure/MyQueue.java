package datastructure;

import java.util.LinkedList;

/**
 * @description:
 * @author: dsy
 * @date: 2021/4/27 23:12
 */
public class MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    /**
     * 入队
     *
     * @param e
     */
    public void enqueue(E e) {
        list.addFirst(e);
    }

    /**
     * 出队
     */
    public E dequeue() {
        return list.removeLast();
    }
}
