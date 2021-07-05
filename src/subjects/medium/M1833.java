package subjects.medium;

import java.util.Arrays;
import java.util.Objects;

/**
 * @description: https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 * @author: dsy
 * @date: 2021/7/2 12:02
 */
public class M1833 {

    public static int maxIceCream(int[] costs, int coins) {
        if(costs.length == 0 || coins == 0){
            return 0;
        }
        Arrays.sort(costs);
        int num = 0;
        int total = 0;
        for (int cost : costs){
            total += cost;
            if(total <= coins){
                num ++;
            }else {
                break;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[] costs = {1,6,3,1,2,5};
        System.out.println(maxIceCream(costs, 20));
    }
}