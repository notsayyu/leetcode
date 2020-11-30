package subjects.sample.string;

/**
 * @description: 转换成小写字母
 * https://leetcode-cn.com/problems/to-lower-case/
 * @author: dsy
 * @date: 2020/11/27 09:31
 */
public class S709 {
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("LOVELY"));
    }
}
