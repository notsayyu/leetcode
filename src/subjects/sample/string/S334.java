package subjects.sample.string;

/**
 * @description: 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 * @author: dsy
 * @date: 2020/11/27 11:18
 */
public class S334 {
    public static char[] reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < s.length / 2; i++) {
            if (i != s.length - i - 1) {
                tmp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = tmp;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        s = reverseString(s);
        System.out.println(s);
    }
}
