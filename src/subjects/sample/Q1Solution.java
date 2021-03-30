package subjects.sample;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author: dsy
 * @date: 2020/4/8 18:39
 */
public class Q1Solution {

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }

        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer result = map.get(nums[i]);
            if (null != result) {
                return new int[]{result, i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(twoSum2(nums, target)[0] + "|" + twoSum2(nums, target)[1]);
    }
}
