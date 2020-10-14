package subjects.sample;

/**
 * @description: 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 * @author: dsy
 * @date: 2020/9/20 22:47
 */
public class S461 {

    public static int hammingDistance(int x, int y) {
//        int num = 0;
//        String xs = Integer.toBinaryString(x);
//        String ys = Integer.toBinaryString(y);
//        for (int i = 0; i < (xs.length() < ys.length() ? xs.length() : ys.length()); i++) {
//            if (xs.charAt(i) != ys.charAt(i)) {
//                num++;
//            }
//        }
//        return num;
//        return Integer.bitCount(x ^ y);
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1) {
                distance += 1;
            }
            xor = xor >> 1;
        }
        return distance;
    }


    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
