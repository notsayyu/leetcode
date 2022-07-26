package datastructure.sort;

/**
 * @description: 归并排序
 * @author: dsy
 * @date: 2022/7/21 13:40
 */
public class MergeSort implements Sorter {
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
        int[] tmp = new int[arr.length];
        sortHelper(arr, 0, arr.length - 1, tmp);
    }

    public void sortHelper(int[] arr, int start, int end, int[] tmp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sortHelper(arr, start, mid, tmp);
        sortHelper(arr, mid + 1, end, tmp);
        merge(arr, start, mid, mid + 1, end, tmp);
    }

    void merge(int[] arr, int s1, int e1, int s2, int e2, int[] tmp) {
        int i = s1;
        int j = s2;
        int k = 0;
        while (i <= e1 && j <= e2) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i];
                i++;
            } else {
                tmp[k++] = arr[j];
                j++;
            }
        }

        while (i <= e1) {
            tmp[k++] = arr[i];
            i++;
        }

        while (j <= e2) {
            tmp[k++] = arr[j];
            j++;
        }

        if (k >= 0) {
            System.arraycopy(tmp, 0, arr, s1, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0, 5};
        Sorter sorter = new MergeSort();
        sorter.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}