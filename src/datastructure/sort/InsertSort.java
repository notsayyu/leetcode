package datastructure.sort;

/**
 * @description: 插入排序
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

    private static void mySort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //从左往右保证顺序
        for (int i = 0; i < arr.length; i++) {
            //要查到最后一位，所以i最大值为arr.length - 1
            //tmp目前等于当前定位到的值arr[i]，但是如果位置不合适，需要往前对比插入
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > tmp) {
                //如果当前i指向的数字比前面的值小，则需要将前面的值往前挪一位，直到找到合适的位置，把tmp插入进去
                arr[j + 1] = arr[j];
                j--;
            }
            //当前就到了合适的位置,因为最后一次交换之后，j --多执行了一次，所以真正的位置在j + 1
            arr[j + 1] = tmp;

        }

    }

    //i = 2; arr[i] = 1; j = 1;  arr[j] = 7; tmp = 1;   arr[j + 1] =  arr[1];  4 7 7 ;j -- = 0; arr[j] = 4;  4 4 7  j =
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0, 8, 5, 20};
        mySort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}