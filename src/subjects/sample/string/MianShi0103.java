package subjects.sample.string;

/**
 * @description: URL化
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 * @author: dsy
 * @date: 2020/12/18 16:16
 */
public class MianShi0103 {
    public static String replaceSpaces(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }

    public static String replaceSpaces1(String S, int length) {
        char[] chars = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index] = S.charAt(i);
                index++;
            }

        }
        return new String(chars, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces1("               ", 5));
    }
}
