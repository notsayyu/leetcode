package other;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author by dsy
 * @Classname ThreadTask3
 * @Description 1加到100，使用线程池、Feature
 * @Date 2022/9/13 10:56
 */
public class ThreadTask3 {
    private static final int index = 101;
    private static final int thNum = 10;
    private static int sum = 0;

    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory());
        List<Future<Integer>> futures = new ArrayList<>();

        int avg = index / thNum;
        int remain = index % thNum;

        int left, right;
        for (int i = 1; i <= thNum; i++) {
            left = (i - 1) * avg + 1;
            if (i == thNum) {
                right = i * avg + remain;
            } else {
                right = i * avg;
            }

            Future<Integer> future = executor.submit(new CountThread(left, right));
            futures.add(future);
        }
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        System.out.println("多线程计算结果为：" + sum);
        executor.shutdown();
    }

    static class CountThread implements Callable<Integer> {
        private final int left;
        private final int right;

        public CountThread(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public Integer call() throws Exception {
            int num = 0;
            for (int i = left; i <= right; i++) {
                num += i;
            }
            return num;
        }
    }
}
