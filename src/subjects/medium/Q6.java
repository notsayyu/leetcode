package subjects.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author: dsy
 * @date: 2021/4/12 12:18
 */
public class Q6 {
    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODE", 3));
    }

}
