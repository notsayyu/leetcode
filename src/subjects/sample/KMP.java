package subjects.sample;

/**
 * @description: https://zhuanlan.zhihu.com/p/83334559
 * @author: dsy
 * @date: 2020/4/2 11:26
 */
public class KMP {

    private int[][] dp;
    private String son;

    /**
     * 使用二维数组，利用有限状态机的思想--确定有限状态自动机、动态规划
     */
    public KMP(String son) {
        this.son = son;
        //son子串长度，也是状态的最大值
        int M = son.length();
        //dp[状态][字符--ASCII码] = 下个状态
        dp = new int[M][256];
        //遇到第一个字符则推进一步，否则其他的都是0
        dp[0][son.charAt(0)] = 1;
        //影子状态，初始为0 --所谓影子状态，就是和当前状态具有相同的前缀
        int X = 0;
        // 当前状态j从1开始
        for (int j = 1; j < M; j++) {
            //c代表此时要遇到的字符，父串的字符， ASCII从0-256
            for (int c = 0; c < 256; c++) {
                if (son.charAt(j) == c) {
                    //遇到的字符跟此时子串的字符抑制，则推进一步
                    dp[j][c] = j + 1;
                } else {
                    //不是的话则重启，回退到影子状态
                    dp[j][c] = dp[X][c];
                }
            }
            //更新影子状态
            X = dp[X][son.charAt(j)];
        }


    }

    public int search(String father) {
        int M = son.length();
        int N = father.length();
        // son 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 当前是状态 j，遇到字符 father[i]，
            // son 应该转移到哪个状态？
            j = dp[j][father.charAt(i)];
            // 如果达到终止态，返回匹配开头的索引
            if (j == M) {
                return i - M + 1;
            }
        }
        // 没到达终止态，匹配失败
        return -1;
    }

    public static void main(String[] args) {
        String son = "ABABC";
        String father = "ABABEABABABABCBA";
        KMP kmp = new KMP(son);
        int[][] dp = kmp.dp;
        System.out.println(kmp.search(father));
    }
}
