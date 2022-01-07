package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/6 21:20
 */
public class JZ4 {
    public static boolean find(int target, int[][] array) {
        if ((array == null || array.length == 0) || (array.length == 1 && array[0].length == 0)) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] array = {{}};
        System.out.println(find(7, array));

    }
}