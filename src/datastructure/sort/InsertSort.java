package datastructure.sort;

/**
 * @description:
 * @author: dsy
 * @date: 2022/7/19 10:36
 */
public class InsertSort implements Sorter {
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

        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0};
        Sorter sorter = new InsertSort();
        sorter.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}