package datastructure.sort;

/**
 * @description: 选择排序
 * @author: dsy
 * @date: 2022/7/20 09:57
 */
public class SelectSort implements Sorter {

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
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                //如果对比的比当前最小的小，就交换
//                if (arr[i] > arr[j]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = tmp;
//                }
//            }
//        }

        for (int i = 0; i < arr.length - 1; i++) {
            //记录下当前轮次的最小数值的下标，最后与i交换，减少中间过程的交换步骤
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                //min一直等于最小值的下标
                if (arr[min] > arr[j]) {
                    min = j;
                }

                if (min != i) {
                    int tmp = arr[min];
                    arr[min] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0};
        Sorter sorter = new SelectSort();
        sorter.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}