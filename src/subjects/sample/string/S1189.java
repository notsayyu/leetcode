package subjects.sample.string;

/**
 * @description: “气球” 的最大数量balloon
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 * @author: dsy
 * @date: 2020/11/27 17:26
 */
public class S1189 {
    public static int maxNumberOfBalloons(String text) {
        int[] nums = new int[5];
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    nums[0]++;
                    break;
                case 'a':
                    nums[1]++;
                    break;
                case 'l':
                    nums[2]++;
                    break;
                case 'o':
                    nums[3]++;
                    break;
                case 'n':
                    nums[4]++;
                    break;
                default:
                    break;
            }
        }
        int result = nums[0];
        for (int i = 0; i < 5; i++) {
            int num = nums[i];
            if (i == 2 || i == 3) {
                num = nums[i] / 2;
            }
            if (result > num) {
                result = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
    }
}
