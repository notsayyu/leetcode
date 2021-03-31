package subjects.sample;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/two-sum/
 * @author: dsy
 * @date: 2020/4/8 18:39
 */
public class Q387 {
    public static int firstUniqChar1(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (1 == map.get(s.charAt(i))) {
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqChar2(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[chars[i] - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(firstUniqChar2("leetcode"));
    }
}
