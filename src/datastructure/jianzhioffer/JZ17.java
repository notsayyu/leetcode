package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/24 18:26
 */
public class JZ17 {
    public static int[] printNumbers(int n) {
        // write code here
        int totalNum = 1;
        for (int i = 0; i < n; i++) {
            totalNum = totalNum * 10;
        }
        totalNum -= 1;
        int[] ints = new int[totalNum];
        for (int j = 0; j < totalNum; j++) {
            ints[j] = j + 1;
        }
        return ints;
    }

}