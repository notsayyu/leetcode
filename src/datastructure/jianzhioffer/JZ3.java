package datastructure.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=265&&tqId=39207&rp=1&ru=/ta/coding-interviews-all&qru=/ta/coding-interviews-all/question-ranking
 * @author: dsy
 * @date: 2022/1/5 20:29
 */
public class JZ3 {
    public static int duplicate(int[] numbers) {
        // write code here
        if (numbers == null || numbers.length < 1) {
            return -1;
        }
        int[] times = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (++times[numbers[i]] > 1) {
                return numbers[i];
            }
        }
        return -1;
    }

    public static int duplicate2(int[] numbers) {
        // write code here
        if (numbers == null || numbers.length < 1) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i])) {
                return numbers[i];
            }
            set.add(numbers[i]);
        }
        return -1;
    }

    public static int duplicate3(int[] numbers) {
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (++arr[numbers[i]] == 2) {
                return numbers[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 2};
        System.out.println(duplicate2(numbers));
    }
}