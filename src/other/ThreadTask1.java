package other;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1加到100，使用CountDownLatch和多个线程
 */
public class ThreadTask1 {
    private static int sum = 0;
    private static int index = 100;
    private static int thNum = 10;

    private static CountDownLatch countDownLatch;
    private static Lock lock;

    public static void main(String[] args) throws InterruptedException {
        countDownLatch  = new CountDownLatch(thNum);
        lock = new ReentrantLock();

        //一共分为10份，每份步长为avg
        int  avg = index/thNum;
        int remain = index % thNum;
        System.out.println(avg);
        System.out.println(remain);
        int left, right;
        for (int i = 1; i <= thNum; i ++){
            left = (i - 1) * avg + 1;
            if(i == thNum){
                right = i * avg + remain;
            }else {
                right = i * avg;
            }
            new Thread(new CountThread(left, right)).start();
        }

        countDownLatch.await();
        System.out.println("计算总数为："+sum);
    }

    static class CountThread implements Runnable{
        private int left;
        private int right;

        public CountThread(int left, int right){
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            int num = 0;
            for (int i = left; i <= right; i ++){
                num += i;
            }
            try{
                lock.lock();
                sum += num;
                countDownLatch.countDown();
            }finally {
                lock.unlock();
            }
        }
    }

}
