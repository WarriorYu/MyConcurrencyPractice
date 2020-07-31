package threadcoreknowledge.stopthreads;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/31
 * Describe : 如果在执行过程中，每次循环都会调用sleep或者wait等方法，那么不需要
 * 每次迭代都检查是否已中断。
 */
public class RightWayStopThreadWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int num = 0;
                try {
                    while (num <= 1000) {
                        if (num % 100 == 0) {
                            System.out.println(num + "是100的倍数");
                        }
                        num++;

                        Thread.sleep(10);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }

}
