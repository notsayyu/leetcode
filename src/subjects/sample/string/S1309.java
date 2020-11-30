package subjects.sample.string;

/**
 * @description: 解码字母到整数映射
 * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * @author: dsy
 * @date: 2020/11/27 09:48
 */
public class S1309 {
    public static String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            //当前字符的后面第二个如果是'#'，表示是j开始，否则是a-i
            if (i + 2 < chars.length && chars[i + 2] == '#') {
                sb.append((char) (Integer.valueOf(s.substring(i, i + 2)) + 96));
                i += 2;
            } else {
                sb.append((char) (chars[i] + ('a' - '1')));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(freqAlphabets("25#"));
    }
}
