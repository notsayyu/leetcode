package subjects.medium;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Q11 {
    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        //左右一个指针，往中间移动
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        //保证左小于右，高的保留，小的往中间移动
        while (left < right) {
            area = Math.max(Math.min(height[left], height[right]) * (right - left), area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 2, 1};

        System.out.println(maxArea(height));
    }
}
