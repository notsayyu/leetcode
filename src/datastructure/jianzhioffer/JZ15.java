package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/23 20:05
 */
public class JZ15 {
    public int NumberOf1(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            num += ((n >> i) & 1);
        }
        return num;
    }
}