package other;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1加到100，使用线程池、CountDownLatch
 */
public class ThreadTask2 {
    private static int sum = 0;
    private static final int index = 100;
    private static final int thNum = 10;

    private static CountDownLatch countDownLatch;
    private static Lock lock;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4, 10, 1L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                new ThreadPoolExecutor.AbortPolicy()
        );

        countDownLatch = new CountDownLatch(thNum);
        lock = new ReentrantLock();

        //一共分为10份，每份步长为avg
        int avg = index / thNum;
        int remain = index % thNum;
        System.out.println(avg);
        System.out.println(remain);
        int left, right;
        for (int i = 1; i <= thNum; i++) {
            left = (i - 1) * avg + 1;
            if (i == thNum) {
                right = i * avg + remain;
            } else {
                right = i * avg;
            }
            executor.execute(new CountThread(left, right));
        }

        countDownLatch.await();
        System.out.println("计算总数为：" + sum);
        executor.shutdown();
    }

    static class CountThread implements Runnable {
        private final int left;
        private final int right;

        public CountThread(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            int num = 0;
            for (int i = left; i <= right; i++) {
                num += i;
            }

            try {
                lock.lock();
                sum += num;
                countDownLatch.countDown();
            } finally {
                lock.unlock();
            }
        }
    }
}
