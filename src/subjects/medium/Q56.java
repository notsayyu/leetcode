package subjects.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * @author: dsy
 * @date: 2021/4/12 10:53
 */
public class Q56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 对 vector<vector<int>> 排序，需要按照先比较区间开始，如果相同再比较区间结束，使用默认的排序规则即可
     * 使用双指针，左边指针指向当前区间的开始
     * 使用一个变量来记录连续的范围 t
     * 右指针开始往后寻找，如果后续的区间的开始值比 t 还小，说明重复了，可以归并到一起
     * 此时更新更大的结束值到 t
     * 直到区间断开，将 t 作为区间结束，存储到答案里
     * 然后移动左指针，跳过中间已经合并的区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int max, i, j = 0;
        while ((i = j) < intervals.length) {   //这主要是用了个表达式一定会返回左值的概念，完成每次循环结束后的赋值和初始赋值
            max = intervals[i][1];
            j = i;                             //这步赋值也可以用上面的方法省略了，但是就太牵强了就算了，可读性还是要的
            while (j < intervals.length && intervals[j][0] <= max) {
                max = Math.max(intervals[j++][1], max);
            }
            merged.add(new int[]{intervals[i][0], max});
        }

        return merged.toArray(new int[merged.size()][2]);   //我比较懒就不自己写拷贝方法了
    }

}
