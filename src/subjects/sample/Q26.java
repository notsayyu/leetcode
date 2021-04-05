package subjects.sample;

/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Q26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int x = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[x]) {
                x++;
                nums[x] = nums[i];
            }
        }
        return x + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

}
