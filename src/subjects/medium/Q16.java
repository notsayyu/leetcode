package subjects.medium;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class Q16 {
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (nums == null || len < 3) {
            return 0;
        }
        Arrays.sort(nums); // 排序
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue; // 去重
//            }

            int L = i + 1;
            int R = len - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum == target) {
                    return result;
                } else if (sum > target) {
                    R--;
                } else {
                    L++;
                }

            }
        }

        return result;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};

        System.out.println(threeSumClosest(nums, 82));
    }
}
