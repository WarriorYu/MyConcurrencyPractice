package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/3
 * Describe : 3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify, notifyAll。 start先执行不代表线程先启动。
 */
public class WaitNotifyAll implements Runnable {
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll runnable = new WaitNotifyAll();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    object.notifyAll();
                    System.out.println("Thread3 notified.");
                }
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread3.start();

    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName()+" got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName()+" waits to start.");
                object.wait();
                System.out.println(Thread.currentThread().getName()+"'s waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
