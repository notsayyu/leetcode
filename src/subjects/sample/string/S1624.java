package subjects.sample.string;

import java.util.HashMap;

/**
 * @description: 两个相同字符之间的最长子字符串
 * https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters/
 * @author: dsy
 * @date: 2020/12/1 21:03
 */
public class S1624 {
    public static int maxLengthBetweenEqualCharacters(String s) {
        //创建Map记录第一次下标
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int res = -1;

        for (int i = 0; i < s.length(); i++) {

            //循环遍历
            if (hashMap.containsKey(s.charAt(i))) {
                //第二次之后 更新返回值
                res = Math.max(res, i - hashMap.get(s.charAt(i)) - 1);
            } else {
                //记录第一次记录
                hashMap.put(s.charAt(i), i);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
    }
}
