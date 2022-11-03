package other;

/**
 * @author by dsy
 * @Classname VolatileTest
 * @Description TODO
 * @Date 2022/9/26 16:06
 */
public class VolatileTest {

    static int maxNum = 100;

    static int num = 1;

    static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        functions(() -> {
            while (num <= maxNum) {
                result += num;
                num++;
            }
        }, 3);

        System.out.println(result);
    }

    public static void functions(Runnable runnable, int num) throws InterruptedException {
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
