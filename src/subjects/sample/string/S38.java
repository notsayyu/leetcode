package subjects.sample.string;

/**
 * @description: 外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 * @author: dsy
 * @date: 2021/3/3 13:10
 */
public class S38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = nextString(s);
        }
        return s;
    }

    String nextString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        char[] cs = s.toCharArray();
        char c = cs[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            char cur = cs[i];
            if (cur == c) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(c);

                c = cur;
                cnt = 1;
            }
        }
        sb.append(cnt);
        sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}

