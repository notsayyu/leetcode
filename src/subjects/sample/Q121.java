package subjects.sample;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Q121 {
    public static int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                result = Math.max(result, prices[i] - min);
            }

        }

        return result;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 这里dp[i - 1][1] + prices[i]为什么能保证卖了一次，因为下面一行代码买的时候已经保证了只买一次，所以这里自然就保证了只卖一次，不管是只允许交易一次还是允许交易多次，这行代码都不用变，因为只要保证只买一次（保证了只卖一次）或者买多次（保证了可以卖多次）即可。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //  - prices[i]这里可以理解为dp[0][0] - prices[i]，这里为什么是dp[0][0] - prices[i]，因为只有这样才能保证只买一次，所以需要用一开始初始化的未持股的现金dp[0][0]减去当天的股价
            dp[i][1] = Math.max(dp[i - 1][1], dp[0][0] - prices[i]);
            // 如果题目允许交易多次，就说明可以从直接从昨天的未持股状态变为今天的持股状态，因为昨天未持股状态可以代表之前买过又卖过后的状态，也就是之前交易过多次后的状态。也就是下面的代码。
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(prices));
    }

}
