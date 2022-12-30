package datastructure.sort;

/**
 * @author by dsy
 * @Classname QuickSelect
 * @Description TODO
 * @Date 2022/12/30 10:47
 */
public class QuickSelect {

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0, 8, 5, 20};
        System.out.println(quickSelect(arr, 2));
    }

    public static int quickSelect(int[] arr, int k) {


        return quickSelectHelper(arr, k, 0, arr.length - 1);
    }

    public static int quickSelectHelper(int[] arr, int k, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int pivotIndex = selectPivotRandom(start, end);

        int index = partition(arr, start, end, pivotIndex);
        if (index == k) {
            return arr[k];
        } else {
            if (k < index) {
                return quickSelectHelper(arr, k, start, index - 1);
            } else {
                return quickSelectHelper(arr, k, index + 1, end);
            }
        }

    }

    private static int partition(int[] arr, int start, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, start, pivotIndex);

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

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int selectPivotRandom(int start, int end) {
        return start + (int) Math.floor(Math.random() * (end - start + 1));
    }
}
