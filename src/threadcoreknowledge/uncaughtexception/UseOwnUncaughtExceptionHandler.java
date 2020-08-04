package threadcoreknowledge.uncaughtexception;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/4
 * Describe :
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-4").start();
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
