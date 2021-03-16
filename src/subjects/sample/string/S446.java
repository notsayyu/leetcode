package subjects.sample.string;

/**
 * @description: 连续字符
 * https://leetcode-cn.com/problems/consecutive-characters/
 * @author: dsy
 * @date: 2021/3/3 11:04
 */
public class S446 {
    public static int maxPower(String s) {
        int max = 1;
        int count = 1;
        char current = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count += 1;
                if (count > max) {
                    max = count;
                }
            } else {
                current = s.charAt(i);
                count = 1;
            }

        }

        return max;
    }

    public static void main(String[] args) {
        String s = "hooraaaaaaaaaaay";
        System.out.println(maxPower(s));
    }
}
