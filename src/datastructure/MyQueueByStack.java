package datastructure;

public class MyQueueByStack<E> {

    //首先有两个栈--后进先出
    private MyStack<E> stackIn;
    private MyStack<E> stackOut;

    public MyQueueByStack(){
        stackIn = new MyStack<>();
        stackOut = new MyStack<>();
    }

    /**
     * 入队的时候将元素放入到入栈
     * @param e
     */
    public void push(E e){
        stackIn.enStack(e);
    }


    /**
     * 出队的时候先判断出栈有没有数据，有的话直接出，没有的话从入栈里面转移到出栈里
     */
    public E pop(){
        if(stackOut.size == 0){
            while (stackIn.size != 0){
                stackOut.enStack(stackIn.deStack());
            }
        }
        return stackOut.deStack();
    }

    public static void main(String[] args) {
        MyQueueByStack<Integer> myQueueByStack = new MyQueueByStack<>();
        myQueueByStack.push(1);
        myQueueByStack.push(2);

        System.out.println(myQueueByStack.pop());
        System.out.println(myQueueByStack.pop());

    }
}
