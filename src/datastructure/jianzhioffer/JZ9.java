package datastructure.jianzhioffer;

import java.util.Stack;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/11 13:21
 */
public class JZ9 {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static int pop2() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        System.out.println(pop2());
        System.out.println(pop2());

    }
}