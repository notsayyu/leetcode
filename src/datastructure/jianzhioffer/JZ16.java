package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/23 20:20
 */
public class JZ16 {
    public static double Power(double base, int exponent) {
        if (0 == exponent) {
            return 1;
        }
        if (1 == exponent) {
            return base;
        }

        base = exponent > 0 ? base : 1 / base;
        exponent = exponent > 0 ? exponent : -exponent;
        double result = base;
        for (int i = exponent; exponent > 1; exponent--) {
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exponent = -2;
        System.out.println(Power(base, exponent));
    }
}