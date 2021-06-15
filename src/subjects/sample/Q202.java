package subjects.sample;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 * @author: dsy
 * @date: 2021/4/11 22:31
 */
public class Q202 {
    public static boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int slow = n, fast = squareSum(n);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }

        return slow == 1;
    }

    public static int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && set.add(n)) {
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy2(1));
    }
}
