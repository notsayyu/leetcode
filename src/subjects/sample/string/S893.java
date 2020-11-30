package subjects.sample.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 特殊等价字符串组
 * https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/
 * @author: dsy
 * @date: 2020/11/27 15:20
 */
public class S893 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();

        for (String str : A) {
            //这个下标0代表偶数位，先把偶数位的放进sb0中，然后转换成char[]类型进行排序
            StringBuilder sb0 = new StringBuilder();
            for (int i = 0; i < str.length(); i += 2) {
                sb0.append(str.charAt(i));
            }
            char[] c0 = sb0.toString().toCharArray();
            Arrays.sort(c0);
            //这个下标1代表奇数位，先把奇数位的放进sb1中，然后转换成char[]类型进行排序
            StringBuilder sb1 = new StringBuilder();
            for (int i = 1; i < str.length(); i += 2) {
                sb1.append(str.charAt(i));
            }
            char[] c1 = sb1.toString().toCharArray();
            Arrays.sort(c1);
            //最后把两个char[] c0 和 c1 转换成String 相加添加到set 里面去
            set.add(String.valueOf(c0) + String.valueOf(c1));
        }
        //最后返回set的大小即可
        return set.size();
    }
}
