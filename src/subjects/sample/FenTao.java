package subjects.sample;

/**
 * @description: 5只猴子一起摘了一堆桃子，因为太累了，它们商量决定，先睡一觉再分。过了不知多久，来了一只猴子，它见别的猴子没来，便将这1堆桃子平均分成5份，
 * 结果多了1个，就将多的这个吃了，拿走其中的1堆。又过了不知多久，第2只猴子来了，它不知道有1个同伴已经来过，还以为自己是第1个呢，
 * 于是将地上的桃子堆起来，平均分成5份，发现也多了1个，同样吃了这1个，拿走其中的1堆。第3只、第4只、第5只猴子都是这样……。
 * 问这5只猴子至少摘了多少个桃子？第5只猴子走后还剩多少个桃子？
 * @author: dsy
 * @date: 2021/3/31 20:30
 */
public class FenTao {

    /**
     * @param count  桃子被分次数
     * @param remain 最后一次可能的桃子数
     * @param total  现有桃子数
     * @return 上一次桃子数
     */
    public static int sum(int count, int remain, int total) {
        total = total / 4 * 5 + 1;
        if (count == 1) {
            return total;
        }
        if (total % 5 == 1 && total % 4 == 0) {
            count--;
        } else {
            count = 5;
            remain += 4;
            total = remain;
        }
        return sum(count, remain, total);
    }

    public static void main(String[] args) {
        System.out.println("海滩原有" + sum(5, 1100, 4) + "个桃子");
    }

}
