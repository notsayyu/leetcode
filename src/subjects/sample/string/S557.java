package subjects.sample.string;

/**
 * @description: 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @author: dsy
 * @date: 2020/11/27 13:41
 */
public class S557 {
    public String reverseWords(String s) {
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();

    }

    public String reverseWords1(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int left = 0;
        int right = 0;
        char temp;
        for (int i = 0; i < n; i++) {
            if (a[i] == ' ') {
                right = i - 1;
                while (left < right) {
                    temp = a[left];
                    a[left++] = a[right];
                    a[right--] = temp;
                }
                left = i + 1;
            }
        }
        right = n - 1;
        while (left < right) {
            temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
        return new String(a);

    }
}
