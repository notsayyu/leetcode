package subjects.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Q3 {
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                //前面存在过这个字符，需要更新一下start位置，保留大的
                start = Math.max(map.get(chars[i]) + 1, start);
            }
            //更新map里面该字符的最新位置
            map.put(chars[i], i);
            length = Math.max(length, i - start + 1);
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
