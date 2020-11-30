package subjects.sample.string;

/**
 * @description: 最长特殊序列 Ⅰ
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 * @author: dsy
 * @date: 2020/11/27 15:26
 */
public class S521 {
    public static int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
