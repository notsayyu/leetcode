package subjects.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * <p>
 * (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) 萌新疑问，为什么最后还要判断前一个数字没有访问过？
 * 我的理解是，如果 nums[i]和nums[i-1]相等，就在所有的全排列里，固定两个相等的数相对的访问顺序，每次必须先访问nums[i-1]再nums[i]，这样就不会产生重复的。 比如【1 1 2 3】， 1的下标分别是0和1， 那么【1 2 1 3】 和【1 2 3 1】两个排列里的两个【1 1】，必须是按nums[0],nums[1]这样的顺序。 如果你把!vis[i - 1] 改成 vis[i - 1] 结果应该也是一样的， 不过因为回溯多，运行时间会久一点
 * @author: dsy
 * @date: 2020/9/18 18:48
 */
public class M47 {

    static boolean[] vis;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11};

        System.out.println(permuteUnique(nums));
    }

}
