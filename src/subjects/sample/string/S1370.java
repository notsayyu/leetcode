package subjects.sample.string;

import java.util.*;

/**
 * @description: 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * <p>
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * <p>
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 * <p>
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 * <p>
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 * <p>
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 * <p>
 * 输入：s = "spo"
 * 输出："ops"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: dsy
 * @date: 2020/11/26 15:08
 */
public class S1370 {
    public static String sortString(String s) {
        StringBuilder sd = new StringBuilder();
        char[] chars = s.toCharArray();
        int[] nums = count(chars);
        while (sd.length() < chars.length) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    sd.append((char) (i + 97));
                    nums[i]--;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > 0) {
                    sd.append((char) (i + 97));
                    nums[i]--;
                }
            }
        }
        return sd.toString();
    }

    /**
     * 失败的方法
     *
     * @param s
     * @return
     */
    public static String sortString1(String s) {
        StringBuilder sd = new StringBuilder();
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        int[] nums = count(chars);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                map.put((char) (i + 97), nums[i]);
            }
        }

        int num;
        while (sd.length() < chars.length) {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                sd.append(entry.getKey());
                num = (int) entry.getValue() - 1;
                if (num < 1) {
                    iter.remove();
                } else {
                    entry.setValue(num);
                }
            }

            // 使用的是迭代器 ListIterator
            ListIterator<Map.Entry> i =
                    new ArrayList<Map.Entry>(
                            map.entrySet()).listIterator(map.size());
            while (i.hasPrevious()) {
                Map.Entry entry = i.previous();
                sd.append(entry.getKey());
                num = (int) entry.getValue() - 1;
                if (num < 1) {
                    i.remove();
                } else {
                    entry.setValue(num);
                }
            }
        }
        return sd.toString();
    }


    public static int[] count(char[] chars) {
        int[] nums = new int[26];
        for (char i : chars) {
            //自动将char i转化成ascall码
            if (i >= 97 && i <= 122) {
                //利用数组的索引进行存储
                nums[i - 97]++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(sortString1("gtqxozxzrssrzxzoxqtg"));
    }


}
