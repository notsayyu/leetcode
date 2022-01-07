package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/7 21:55
 */
public class JZ5 {
    public static String replaceSpace(String s) {
        // write code here
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (' ' == (chars[i])) {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }

    public static String replaceSpace2(String s) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "We Are Happy";
        System.out.println(s.replace(" ", "%20"));
    }
}