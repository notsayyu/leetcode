package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/17 13:06
 */
public class JZ12 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix char字符型二维数组
     * @param word   string字符串
     * @return bool布尔型
     */
    public boolean hasPath(char[][] matrix, String word) {
        // write code here
        char[] words = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(matrix, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] matrix, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于matrix[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0 || matrix[i][j] != word[index]) {
            return false;
        }
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1) {
            return true;
        }
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = matrix[i][j];
        //然后修改当前坐标的值
        matrix[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(matrix, word, i + 1, j, index + 1)
                || dfs(matrix, word, i - 1, j, index + 1)
                || dfs(matrix, word, i, j + 1, index + 1)
                || dfs(matrix, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        matrix[i][j] = tmp;
        return res;
    }
}