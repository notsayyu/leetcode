package subjects.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:  多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: dsy
 * @date: 2020/9/22 21:17
 */
public class S169 {

        public static int majorityElement(int[] nums) {
            //一共n个数据
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i : nums){
                if(map.get(i) == null){
                    if(1 > n/2){
                        return i;
                    }else {
                        map.put(i, 1);
                    }
                }else {
                    int number = map.get(i);
                    number ++;
                    if(number > (n/2)){
                        return i;
                    }else {
                        map.put(i, number);
                    }
                }
            }
            return 0;
        }

    /**
     *如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为 n/2 的元素（下标从 0 开始）一定是众数
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法思路
     *https://leetcode-cn.com/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement1(nums));
    }
}
