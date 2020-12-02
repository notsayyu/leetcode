package subjects.sample.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 计数二进制子串
 * https://leetcode-cn.com/problems/count-binary-substrings/
 * @author: dsy
 * @date: 2020/12/2 12:34
 */
public class S696 {
    public static int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
}
