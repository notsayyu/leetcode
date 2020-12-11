package subjects.sample.string;

import java.util.Arrays;

/**
 * @description: 比较字符串最小字母出现频次
 * https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 * @author: dsy
 * @date: 2020/12/10 16:08
 */
public class S1170 {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] nums = new int[queries.length];
        int[] wordNums = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            wordNums[i] = getNumFromString(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            int num = getNumFromString(queries[i]);
            for (int j = 0; j < words.length; j++) {
                if (num < wordNums[j]) {
                    nums[i] += 1;
                }
            }
        }

        return nums;
    }

    public int[] numSmallerByFrequency1(String[] queries, String[] words) {
        //count用于统计words中所有单词的最小字母出现次数，
        //大小设置为12是为了避免下面进行判定的时候出现越界而做的冗余处理
        int[] count = new int[12];
        for (String word : words) {
            count[getNumFromString(word)]++;
        }
        //计算后缀和，现在count[i]表示最小字母出现次数大于或等于i的单词总数。
        for (int i = 9; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        //结果数组
        int[] result = new int[queries.length];
        //遍历queries中的每个字符串，利用前面计算得到的count数组，可以直接得到答案。
        for (int i = 0; i < queries.length; i++) {
            result[i] = count[getNumFromString(queries[i]) + 1];
        }
        return result;
    }


    private static int getNumFromString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char c = s.charAt(0);
        int num = 0;
        for (char c1 : s.toCharArray()) {
            if (c1 < c) {
                c = c1;
                num = 1;
            } else if (c == c1) {
                num += 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};

        System.out.println(Arrays.toString(numSmallerByFrequency(queries, words)));
    }
}
