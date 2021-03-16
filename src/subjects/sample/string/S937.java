package subjects.sample.string;

import java.util.Arrays;

/**
 * @description: 重新排列日志文件
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 * @author: dsy
 * @date: 2020/12/22 12:50
 */
public class S937 {
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public static void main(String[] args) {
        String s = "a1 9 2 3 1";
        String[] strings = s.split(" ", 2);
        boolean isDigit1 = Character.isDigit(strings[1].charAt(0));
        System.out.println(isDigit1);
    }
}
