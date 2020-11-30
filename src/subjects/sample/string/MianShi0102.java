package subjects.sample.string;

import java.util.Arrays;

/**
 * @description: 面试题 01.02. 判定是否互为字符重排
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 * @author: dsy
 * @date: 2020/11/27 16:39
 */
public class MianShi0102 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }
}
