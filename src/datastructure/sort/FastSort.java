package datastructure.sort;

/**
 * @description: 快速排序
 * @author: dsy
 * @date: 2022/7/19 10:36
 */
public class FastSort implements Sorter {

    //i = 2; arr[i] = 1; j = 1;  arr[j] = 7; tmp = 1;   arr[j + 1] =  arr[1];  4 7 7 ;j -- = 0; arr[j] = 4;  4 4 7  j =
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0, 8, 5, 20};
        FastSort fastSort = new FastSort();
        fastSort.mySort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        for (int j = start + 1; j <= end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, start, i - 1);
        return i - 1;
    }

    private static void sortHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = partition(arr, start, end);
        sortHelper(arr, start, index - 1);
        sortHelper(arr, index + 1, end);

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void mySort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        mySortHelper(arr, 0, arr.length - 1);
    }

    private void mySortHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int center = mediaOf3Nums(arr, start, (start + end) / 2, end);
        swap(arr, start, center);

        int index = partition3(arr, start, end);
        mySortHelper(arr, start, index - 1);
        mySortHelper(arr, index + 1, end);
    }

    private int partition2(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        for (int j = start + 1; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, start, i - 1);
        return i - 1;
    }

    private int partition3(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, start, i - 1);
        return i - 1;
    }

    private int mediaOf3Nums(int[] arr, int start, int center, int end) {
        if (arr[start] < arr[center]) {
            if (arr[center] < arr[end]) {
                return center;
            } else {
                return arr[start] < arr[end] ? end : start;
            }
        } else {
            if (arr[center] > arr[end]) {
                return center;
            } else {
                return arr[start] > arr[end] ? end : start;
            }
        }

    }

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

        sortHelper(arr, 0, arr.length - 1);
    }


}