package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/2/2 09:12
 */
public class JZ21 {
    public static int[] reOrderArray(int[] array) {
        // write code here
        int[] newArr = new int[array.length];
        int oddNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                newArr[oddNum] = array[i];
                oddNum++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                newArr[oddNum] = array[i];
                oddNum++;
            }
        }

        return newArr;
    }

    public static int[] reOrderArray2(int[] array) {
        // write code here
        // 首先是对数值长度进行特判
        if (array == null || array.length == 0) {
            return array;
        }
        //记录已经是奇数的位置
        int j = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            //如果该值为偶数
            if (array[i] % 2 != 0) {
                //该值为奇数
                int k = i;
                while (k > j) {
                    //这区间整体向后移动一位
                    array[k] = array[k - 1];
                    k--;
                }
                //移位之后将对应的值赋值
                array[k] = temp;
                j++;
            }
        }
        //返回结果数数组
        return array;
    }

    public int[] reOrderArray3(int[] array) {
        // write code here
        //所给数组的长度
        int len = array.length;
        //辅助数组
        int[] nums = new int[len];
        //双指针：left right并初始化
        int left = 0;
        int right = len - 1;
        int tp_left = left;
        int tp_right = right;
        //循环终止条件：left<len && right>=0
        while (left < len && right >= 0) {
            //处理奇数情况
            if (array[left] % 2 == 1) {
                nums[tp_left] = array[left];
                tp_left++;
            }
            left++;
            //处理偶数情况
            if (array[right] % 2 == 0) {
                nums[tp_right] = array[right];
                tp_right--;
            }
            //向左移动指针right
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 6, 5, 7};

        int[] newArr = reOrderArray2(array);
        for (int i : newArr) {
            System.out.println(i);
        }
    }
}