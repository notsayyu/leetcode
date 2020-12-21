package subjects.sample.string;

/**
 * @description: 千位分隔数
 * https://leetcode-cn.com/problems/thousand-separator/
 * @author: dsy
 * @date: 2020/12/17 17:05
 */
public class S1556 {
    public static String thousandSeparator(int n) {
        int count = 0;
        StringBuffer ans = new StringBuffer();
        do {
            int cur = n % 10;
            n /= 10;
            ans.append(cur);
            ++count;
            if (count % 3 == 0 && n != 0) {
                ans.append('.');
            }
        } while (n != 0);
        ans.reverse();
        return ans.toString();
    }

    public static String thousandSeparator1(int n) {
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        for (int i = sb.length() - 3; i > 0; i -= 3) {
            sb.insert(i, '.');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int s = 1234;
        System.out.println(thousandSeparator(s));
    }
}
