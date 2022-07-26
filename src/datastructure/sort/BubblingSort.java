package datastructure.sort;

/**
 * @description: 冒泡排序
 * @author: dsy
 * @date: 2022/7/19 09:03
 */
public class BubblingSort implements Sorter {
    /**
     * 数组排序
     *
     * @param arr
     * @return
     */
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

    }

    private static void mySort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            //循环长度-1次，最后一个不需要再排了
            //每次把未排序的最大的数值排到最后面,未排序的长度为0 ~ arr.length-1-i   [4, 7, 1, 3, 9, 0]
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果j的值比j+1的值大，则位置互换，保证j没走一步，j+1的值都是最大的，走到最后一步的时候，j = arr.length - 1 - i -1， j + 1 = arr.length - 1 - i
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0, 8, 5, 20};
        mySort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}