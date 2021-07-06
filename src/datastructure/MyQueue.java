package datastructure;

import java.util.LinkedList;

/**
 * @description:
 * @author: dsy
 * @date: 2021/4/27 23:12
 */
public class MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>();
    public int size;

    public MyQueue() {
        this.size = 0;
    }

    /**
     * 入队
     *
     * @param e
     */
    public void enqueue(E e) {
        if(e == null){
            return;
        }
        list.addFirst(e);
        size ++;
    }

    /**
     * 出队
     */
    public E dequeue() {
        size --;
        return list.removeLast();
    }
}
