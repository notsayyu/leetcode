package subjects.difficulty;

/**
 * 接雨水
 */
public class Q42 {
    public static int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        //计算左边的最大值
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //计算左边的最大值，从n-2开始
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        //从1到n-2计算雨水
        for (int i = 1; i <= n - 2; i++) {
            //当前列的雨水量为左边和右边最大小高度减去当前的高度，leftMax[i]/rightMax[i] - height[i];
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }
}

