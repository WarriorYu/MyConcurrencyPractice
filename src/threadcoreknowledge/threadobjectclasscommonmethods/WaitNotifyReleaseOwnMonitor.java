package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/3
 * Describe :  证明wait只释放当前的那把锁
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object resourseA = new Object();
    private static volatile Object resourseB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourseA) {
                    System.out.println("ThreadA got resourceA lock");
                    synchronized (resourseB) {
                        System.out.println("ThreadA got resourceB lock");
                        try {
                            System.out.println("ThreadA release resourceA lock");
                            resourseA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 让ThreadA执行到wait方法
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourseA) {
                    System.out.println("ThreadB got resourceA lock.");
                    System.out.println("ThreadB tries to resourceB lock.");
                    synchronized (resourseB) {
                        System.out.println("ThreadB got resourceB lock.");
                    }
                }

            }
        });

        threadA.start();
        threadB.start();
    }
}
