package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/3
 * Describe : 演示sleep的时候不释放lock(lock需要手动释放)
 */
public class SleepDontReleaseLock implements Runnable {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        SleepDontReleaseLock sleepDontReleaseLock = new SleepDontReleaseLock();
        new Thread(sleepDontReleaseLock).start();
        new Thread(sleepDontReleaseLock).start();

    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "获取了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
