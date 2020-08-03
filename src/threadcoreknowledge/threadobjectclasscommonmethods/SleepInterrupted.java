package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/3
 * Describe : 每隔一秒钟输出当前时间，中断，观察。
 * Thread.sleep(...)
 * TimeUnit.SECONDS.sleep(...);
 */
public class SleepInterrupted implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        SleepInterrupted sleepInterrupted = new SleepInterrupted();
        Thread thread = new Thread(sleepInterrupted);
        thread.start();
//        Thread.sleep(6500);
        TimeUnit.SECONDS.sleep(6);
        TimeUnit.MILLISECONDS.sleep(500);
        thread.interrupt();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
//                Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了！");
                e.printStackTrace();
            }
        }
    }
}
