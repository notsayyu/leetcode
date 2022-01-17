package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/13 13:45
 */
public class JZ11 {
    public int minNumberInRotateArray(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 1 2 3 4 5 6 7    4 5 6 7 1 2 3
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int[] array) {
        // 定义左边界
        int left = 0;
        // 定义有边界-----在二分查找中，左边界值一定小于或等于右边界值
        int right = array.length - 1;
        while (left <= right) {
            // 计算左右区间最中间的索引
            int mid = left + ((right - left) >> 1);
            // 如果中间的值小于右边的值，说明此时数组最小值在左半部，
            // 挪动右边界指针到中间索引，为了避免此时的中间索引值就是最小的值，所以mid不能够减1
            if (array[mid] < array[right]) {
                right = mid;
            }
            // 如果中间的值大于右边的值，说明此时的最小值在右半部，挪动左边界指针到当前中间索引的后一个
            else if (array[mid] > array[right]) {
                left = mid + 1;
            }
            // 如果中间值与右边界值相同，那么挪动右边界向左靠一位，这样就可以在下次循环时重新计算出中间索引值
            else {
                right--;
            }
        }
        // 左边界永远小于或等于右边界，那么就直接返回左边界所对应的数组值
        return array[left];
    }
}