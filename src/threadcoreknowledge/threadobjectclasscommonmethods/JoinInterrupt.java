package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/3
 * Describe : 演示join期间被中断的效果
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainThread.interrupt();
                    Thread.sleep(5000);
                    System.out.println("Thread1 finished.");
                } catch (InterruptedException e) {
                    System.out.println("子线程中断");
                }
            }
        });

        thread.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"主线程中断了");
            thread.interrupt();
        }
        System.out.println("子线程已运行完毕");

    }
}
