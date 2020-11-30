package subjects.sample.string;

/**
 * @description: 机器人能否返回原点
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 * @author: dsy
 * @date: 2020/11/27 09:22
 */
public class S657 {

    public static boolean judgeCircle(String moves) {
        int vert = 0;
        int cross = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                cross++;
            } else if (c == 'L') {
                cross--;
            } else if (c == 'U') {
                vert++;
            } else {
                vert--;
            }
        }

        return vert == 0 && cross == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("LL"));
    }
}
