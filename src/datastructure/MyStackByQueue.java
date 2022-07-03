package datastructure;

public class MyStackByQueue<E> {
    // 首先有两个队列--先进先出
    private MyQueue<E> queueIn;
    private MyQueue<E> queueOut;

    public MyStackByQueue(){
        queueIn = new MyQueue<>();
        queueOut = new MyQueue<>();
    }

    /**
     * 入栈，将元素放入入队列
     */
    public void push(E e){
        queueIn.enqueue(e);
    }

    /**
     * 出栈，判断入队列里面的元素，如果是一个就直接pop，如果多个就只保留一个，其他的转移到出队列
     */
    public E pop(){
        //TODO 判空
        while (queueIn.size >1){
            queueOut.enqueue(queueIn.dequeue());
        }
        E result = queueIn.dequeue();
        //交换两个队列的角色，入队都是有元素的，或者两个都是空就无所谓
        swap();
        return result;
    }

    private void swap(){
        MyQueue<E> tmp = queueIn;
        queueIn = queueOut;
        queueOut = tmp;
    }

    public static void main(String[] args) {
        MyStackByQueue<Integer> myStackByQueue = new MyStackByQueue<>();
        myStackByQueue.push(1);
        myStackByQueue.push(2);

        System.out.println(myStackByQueue.pop());
        System.out.println(myStackByQueue.pop());

    }
}
