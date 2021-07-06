package datastructure.sort;

/**
 * @description: 堆排序
 * @author: dsy
 * @date: 2021/7/6 13:51
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort2(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort2(int [] array){

        //1、先将数据转为堆结构
        //数组的初始状态实际上就对应了初始堆得状态，不需要使用代码进行转换

        //4、实现一个循环。每一次都表示一个元素有序，每一次都将参与堆排序的数组的最大下标向前提一个

        for (int end = array.length - 1; end > 0; end --) {
            //2、将对结构不断地调整为大根堆
            maxHeap(array, end);

            //3、将堆顶元素（此时表示的是堆当中最大的元素）和堆得最后一个叶子节点进行交换，表示这个元素已经有序
            int tem = array[0];
            array[0] = array[end];
            array[end] = tem;
        }
    }

    /**
     * 构建大根堆得方法
     * @param array 构建大根堆得数组
     * @param end 参与构建大根堆数组元素的最大下标，相当于堆中最后一个节点（叶子结点）在数组array中的对应下标
     */
    private static void maxHeap(int[] array, int end){
        //1、根据公式计算出堆结构中最后一个父节点的下标：[(start + end) / 2]↑ -1  ↑：向上取整
        int lastFather = end % 2 != 0 ? end / 2 : end / 2 -1;

        //5、从最后一个父节点开始向前不断-1，使得每个父节点都能够实现左右PK，以下犯上的步骤
        for (int father = lastFather; father >= 0; father --){
            //2、根据父节点的下标推算出左右孩子的数组下标
            //左孩子： 2n+1   右孩子：2n+2
            int left = father * 2 +1;
            int right = father * 2 + 2;

            //3、在保证右孩子下标没有越界的情况下，使用右孩子和父节点进行比较
            //如果右孩子 》 父节点的，进行交换
            if(right <= end && array[right] > array[father]){
                int tmp = array[right];
                array[right] = array[father];
                array[father] = tmp;
            }

            //4、使用左孩子和父亲节点进行比较，如果左孩子 》 父节点，进行交换，步骤4相当于间接的进行了左右孩子的大小比较
            if(array[left] > array[father]){
                int tmp = array[left];
                array[left] = array[father];
                array[father] = tmp;
            }
        }
    }



    /**
     * 创建堆，
     * @param arr 待排序列
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }
}