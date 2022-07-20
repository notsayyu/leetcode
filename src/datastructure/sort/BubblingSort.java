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

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0};
        Sorter sorter = new BubblingSort();
        sorter.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}