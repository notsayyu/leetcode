package other;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Controller {
    final ReentrantLock lock = new ReentrantLock();
    volatile int num = 9;

    static class Task implements Runnable {

        private String name;

        private Condition condition;

        private int num;

        private ReentrantLock lock;


        public Task(String name, Condition condition, int num, ReentrantLock lock) {
            this.name = name;
            this.condition = condition;
            this.num = num;
            this.lock = lock;
        }

        void stage1() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                System.out.println(name + "stage 1 finished");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void stage2() {
            try {

                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                System.out.println(name + "stage 2 finished");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void stage3() {
            try {

                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                System.out.println(name + "stage 3 finished");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            lock.lock();
            stage1();
            num--;
            if (num == 6) {
                condition.notifyAll();
            }
//            lock.unlock();

//            lock.lock();
            if (num > 6) {
                try {
                    condition.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stage2();
            num--;
            if (num == 3) {
                condition.notifyAll();
            }
//            lock.unlock();

//            lock.lock();
            if (num > 3) {
                try {
                    condition.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stage3();
            num--;

            lock.unlock();
        }
    }

    public void run() {
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        Task task1 = new Task("task1", condition1, num, lock);
        Thread thread1 = new Thread(task1);

        Task task2 = new Task("task2", condition1, num, lock);
        Thread thread2 = new Thread(task2);

        Task task3 = new Task("task3", condition1, num, lock);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

public class Solution {
    //1.启动三个线程
    //2.每个线程的Task必须同时按照阶段完成完成，比如task1的第二阶段的开始比如是task2,task3的第一阶段的完成后发生
    //3.不能再使用synchronized关键字，和JUC其他组件，里面内含一个ReentranceLock()
    //Solution的代码不能改变，其他类定义可以修改
    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.run();
    }
}