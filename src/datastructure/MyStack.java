package datastructure;

import java.util.LinkedList;

/**
 * @description: 栈--先进后出
 * @author: dsy
 * @date: 2021/4/27 23:12
 */
public class MyStack<E> {
    private LinkedList<E> list = new LinkedList<>();

    public int size;

    public MyStack() {
        this.size = 0;
    }

    /**
     * 入栈
     *
     * @param e
     */
    public void enStack(E e) {
        list.addFirst(e);
        size ++;
    }

    /**
     * 出栈
     */
    public E deStack() {
        size --;
        return list.removeFirst();
    }
}
