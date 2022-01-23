package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/20 13:16
 */
public class JZ14 {
    public int cutRope(int target) {
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int res = 1;
        while (target > 4) {
            //如果target大于4，我们不停的让他减去3
            target = target - 3;
            //计算每段的乘积
            res = res * 3;
        }
        return target * res;
    }
}