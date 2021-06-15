package datastructure;

/**
 * @description:
 * @author: dsy
 * @date: 2021/4/27 23:16
 */
public class LinkListTest {
    public static void main(String[] args) {
        //测试栈
        MyStack<String> stack = new MyStack<>();
        stack.enStack("stack1");
        stack.enStack("stack2");
        System.out.println(stack.deStack());
        stack.enStack("stack3");
        System.out.println(stack.deStack());
        System.out.println(stack.deStack());

        //测试队列
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("queue1");
        queue.enqueue("queue2");
        System.out.println(queue.dequeue());
        queue.enqueue("queue3");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
