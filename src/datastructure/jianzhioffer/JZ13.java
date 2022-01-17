package datastructure.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/17 18:40
 */
public class JZ13 {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] visited = new int[rows][cols];
        return dfs(0, 0, rows, cols, threshold, visited);
    }

    /**
     * @param i         当前机器人所在的rows 行
     * @param j         当前机器人所在的cols 列
     * @param rows
     * @param cols
     * @param threshold
     * @param visited
     * @return
     */
    public int dfs(int i, int j, int rows, int cols, int threshold, int[][] visited) {
        if (i >= rows || j >= cols || threshold < sum(i, j) || visited[i][j] != 0) {
            return 0;
        }
        //标识被访问过
        visited[i][j] = 1;

        //机器人从0,0开始走，每次只需要向右或者向下走就可以
        return 1 + dfs(i + 1, j, rows, cols, threshold, visited) +
                dfs(i, j + 1, rows, cols, threshold, visited);
    }

    public int movingCount2(int threshold, int rows, int cols) {
        //临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[rows][cols];
        int res = 0;
        //创建一个队列，保存的是访问到的格子坐标，是个二维数组
        Queue<int[]> queue = new LinkedList<>();
        //从左上角坐标[0,0]点开始访问，add方法表示把坐标
        // 点加入到队列的队尾
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            //这里的poll()函数表示的是移除队列头部元素，因为队列
            // 是先进先出，从尾部添加，从头部移除
            int[] x = queue.poll();
            int i = x[0], j = x[1];
            //i >= rows || j >= cols是边界条件的判断，threshold < sum(i, j)判断当前格子坐标是否
            // 满足条件，visited[i][j]判断这个格子是否被访问过
            if (i >= rows || j >= cols || threshold < sum(i, j) || visited[i][j]) {
                continue;
            }
            //标注这个格子被访问过
            visited[i][j] = true;
            res++;
            //把当前格子右边格子的坐标加入到队列中
            queue.add(new int[]{i + 1, j});
            //把当前格子下边格子的坐标加入到队列中
            queue.add(new int[]{i, j + 1});
        }
        return res;
    }


    public int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}